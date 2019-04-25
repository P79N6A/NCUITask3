package com.netcracker.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.GenService;
import com.netcracker.shared.author.Author;
import com.netcracker.shared.book.Book;
import com.netcracker.shared.structures.Date;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GenServiceImpl extends RemoteServiceServlet implements GenService {

    public ArrayList<Book> addRow(Book book, boolean kolStrSort) {
        int id = readBooks().get(readBooks().size() - 1).getId() + 1;
        try (FileWriter writer = new FileWriter(BookBSD.fileFullName, true)) {
            String[] bookObjects = {"" + id + " ",
                    book.getAuthor().getName() + " ",
                    "" + book.getAuthor().getGender() + " ",
                    book.getAuthor().getEmail() + " ",
                    book.getName() + " ",
                    "" + book.getKolStr() + " ",
                    book.getDateIsd().toString() + " ",
                    book.getDateAdd().toString()};
            writer.write("\n");
            for (String str : bookObjects) {
                writer.write(str);
            }
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (kolStrSort) {
            return kolStrSort();
        }
        return readBooks();
    }

    public ArrayList<Book> deleteBook(Book book, boolean kolStrSort) {
        ArrayList<Book> books = readBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(book)) {
                books.remove(i);
                break;
            }
        }
        writeBooks(books);
        if (kolStrSort) {
            return kolStrSort();
        }
        return readBooks();
    }

    public ArrayList<Book> changeBook(Book oldBook, Book newBook, boolean kolStrSort) {
        ArrayList<Book> books = readBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(oldBook)) {
                books.set(i, newBook);
                break;
            }
        }
        writeBooks(books);
        if (kolStrSort) {
            return kolStrSort();
        }
        return readBooks();
    }

    public Book getBook(Integer id) {
        return new Book();
    }

    public ArrayList<Book> reloadTable(Integer size, boolean kolStrSort) {
        try (FileWriter writer = new FileWriter(BookBSD.fileFullName)) {
            for (int i = 0; i < BookBSD.books.size(); i++) {
                Book book = BookBSD.books.get(i);
                String[] bookObjects = {"" + book.getId() + " ",
                        book.getAuthor().getName() + " ",
                        "" + book.getAuthor().getGender() + " ",
                        book.getAuthor().getEmail() + " ",
                        book.getName() + " ",
                        "" + book.getKolStr() + " ",
                        book.getDateIsd().toString() + " ",
                        book.getDateAdd().toString()};
                for (String str : bookObjects) {
                    writer.write(str);
                }
                if (i < BookBSD.books.size() - 1) {
                    writer.write("\n");
                }
            }
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getFirstBooks(size, kolStrSort);
    }

    public ArrayList<Book> getBookArray(Integer firstElem, Integer size) {
        ArrayList<Book> books = new ArrayList<>();
        try (FileReader fileReader = new FileReader(BookBSD.fileFullName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                while (scanner.hasNext()) {
                    books.add(
                            new Book(
                                    scanner.nextInt(),
                                    new Author(
                                            scanner.next(),
                                            scanner.next(),
                                            scanner.next()
                                    ),
                                    scanner.next(),
                                    scanner.nextInt(),
                                    new Date(scanner.next()),
                                    new Date(scanner.next())
                            )
                    );
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return books;
    }

    private ArrayList<Book> readBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (FileReader fileReader = new FileReader(BookBSD.fileFullName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                books.add(
                        new Book(
                                scanner.nextInt(),
                                new Author(
                                        scanner.next(),
                                        scanner.next(),
                                        scanner.next()
                                ),
                                scanner.next(),
                                scanner.nextInt(),
                                new Date(scanner.next()),
                                new Date(scanner.next())
                        )
                );
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return books;
    }

    private void writeBooks(ArrayList<Book> books) {
        try (FileWriter writer = new FileWriter(BookBSD.fileFullName, false)) {
            for (int i = 0; i < books.size(); i++) {
                String[] bookObjects = {"" + books.get(i).getId() + " ",
                        books.get(i).getAuthor().getName() + " ",
                        "" + books.get(i).getAuthor().getGender() + " ",
                        books.get(i).getAuthor().getEmail() + " ",
                        books.get(i).getName() + " ",
                        "" + books.get(i).getKolStr() + " ",
                        books.get(i).getDateIsd().toString() + " ",
                        books.get(i).getDateAdd().toString()};
                for (String str : bookObjects) {
                    writer.write(str);
                }
                if (i < books.size() - 1) writer.write("\n");
            }
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private ArrayList<Book> getFirstBooks(Integer size, boolean kolStrSort) {
        ArrayList<Book> books;
        if (kolStrSort)
            books = kolStrSort();
        else books = readBooks();
        ArrayList<Book> result = new ArrayList<>();
        int length = 0;
        if (size >= books.size()) {
            for (int i = 0; i < books.size(); i++) {
                result.add(books.get(i));
            }
        } else {
            for (int i = 0; i < size; i++) {
                result.add(books.get(i));
            }
        }
        return result;
    }

    public ArrayList<Book> goToPage(int page, int size, boolean kolStrSort) {
        ArrayList<Book> books;
        if (kolStrSort)
            books = kolStrSort();
        else books = readBooks();
        ArrayList<Book> result = new ArrayList<>();
        int sizeTable = readBooks().size();
        int pages = sizeTable / size;
        if (sizeTable % size > 0) {
            pages++;
        }

        //System.out.println(books);
        if (page >= 0 && page < pages) {
            //TablePageControl.incrementPage();
            int savePoint = page * size;
            int newPoint = savePoint + size;
            if (books.size() < newPoint) {
                newPoint = books.size();
            }
            for (int i = savePoint; i < newPoint; i++) {
                result.add(books.get(i));
            }
        }
        return result;
    }

    public ArrayList<Book> goToLastPage(int size, boolean kolStrSort) {
        ArrayList<Book> books;
        if (kolStrSort)
            books = kolStrSort();
        else books = readBooks();
        ArrayList<Book> result = new ArrayList<>();
        int sizeTable = readBooks().size();
        int pages = sizeTable / size;
        if (sizeTable % size > 0) {
            pages++;
        }
        int savePoint = size * (pages - 1);
        if (savePoint < 0) savePoint = 0;
        int newPoint = savePoint + size;
        if (books.size() < newPoint) {
            newPoint = books.size();
        }
        for (int i = savePoint; i < newPoint; i++) {
            result.add(books.get(i));
        }
        return result;
    }

    public ArrayList<Book> goToFirstPage(int size, boolean kolStrSort) {
        return getFirstBooks(size, kolStrSort);
    }

    private ArrayList<Book> kolStrSort() {
        ArrayList<Book> books = readBooks();
        Collections.sort(books);
        return books;
    }
}