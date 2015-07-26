package miko.test.project;

import miko.test.project.crud.BookCrud;
import miko.test.project.entity.Book;
import java.util.List;


public class App {

    public static void main(String[] args) {

        Book book = new Book();
        book.setBookAuthorAndName("Miko Kozh - Romul as the way to live like a human.");

        BookCrud.addBook(book);
        List<Book> books = BookCrud.getAllBooks();
        for (Book book1 : books) {
            System.out.println(book1.getBookAuthorAndName());
        }

    }


}
