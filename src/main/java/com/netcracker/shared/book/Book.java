package com.netcracker.shared.book;

import com.netcracker.shared.author.Author;
import com.netcracker.shared.structures.Date;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable, Comparable {

    private static int lastId;
    private int id;
    private Author author;
    private String name;
    private int kolStr;
    private Date dateIsd;
    private Date dateAdd;

    public Book() {
    }

    public Book(int id, Author author, String name, int kolStr, Date dateIsd, Date dateAdd) {
        if(lastId<id)
        {
            lastId = id;
        }
        this.id = id;
        this.author = author;
        this.name = name;
        this.kolStr = kolStr;
        this.dateIsd = dateIsd;
        this.dateAdd = dateAdd;
    }

    public static int getLastId(){return lastId;}

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getKolStr() {
        return kolStr;
    }

    public Date getDateIsd() {
        return dateIsd;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKolStr(int kolStr) {
        this.kolStr = kolStr;
    }

    public void setDateIsd(Date dateIsd) {
        this.dateIsd = dateIsd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public String  toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", kolStr=" + kolStr +
                ", dateIsd=" + dateIsd +
                ", dateAdd=" + dateAdd +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if( ((Book) o).getKolStr()>this.kolStr) return -1;
        else if(((Book) o).getKolStr()==this.kolStr) return 0;
        else return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id &&
                kolStr == book.kolStr &&
                Objects.equals(author, book.author) &&
                Objects.equals(name, book.name) &&
                Objects.equals(dateIsd, book.dateIsd) &&
                Objects.equals(dateAdd, book.dateAdd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, author, name, kolStr, dateIsd, dateAdd);
    }
}
