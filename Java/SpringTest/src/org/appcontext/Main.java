package org.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        FirstSpring obj = context.getBean("firstSpring", FirstSpring.class);
        Book book = context.getBean("book", Book.class);
        System.out.println(book.getTitle());
        System.out.println();

        Author author = context.getBean("author", Author.class);
        System.out.println(author.getName());

        List<Book> books = author.getBooks();
        for (Book book1 :
                books) {
            System.out.println(book1.getTitle());
        }
    }
}
