package org.appcontext;

import java.util.List;

public class Author {
    String name;

    List<Book> books;

    /*Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
