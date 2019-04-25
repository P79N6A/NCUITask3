package com.netcracker.shared.author;

import java.io.Serializable;

public class Author implements Serializable {
    private String name;
    private String gender;
    private String email;

    public Author()
    {

    }

    public Author(String name, String gender, String email) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Author(Author author) {
        this.name = author.name;
        this.gender = author.gender;
        this.email = author.email;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Author)) return false;
        if (((Author) o).name.equals(this.name) &&
                ((Author) o).gender.equals(this.gender) &&
                ((Author) o).email.equals(this.email)) return true;
        return false;
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + gender.hashCode();
        hashCode = 31 * hashCode + email.hashCode();
        return hashCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + "("+ gender + ")"+
                ", email:" + email;
    }
}
