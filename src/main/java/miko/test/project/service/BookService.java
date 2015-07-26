package miko.test.project.service;

import miko.test.project.crud.BookCrud;
import miko.test.project.entity.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("hello")
public class BookService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello!";
    }

    @GET
    @Path("{name}")
    public String sayHello(@PathParam("name") String name){
        StringBuilder stringBuilder = new StringBuilder("SandBox | Hello ");
        stringBuilder.append(name).append("!");

        return stringBuilder.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/booklist")
    public Response getList() {
        populateBooks();
        List<Book> books = BookCrud.getAllBooks();
//        String book = books.get(0).getBookAuthorAndName();

        GenericEntity<List<Book>> list = new GenericEntity<List<Book>>(books){};

        return Response.ok(list).build();
//        return BookCrud.getAllBooks();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public Book getBook() {
        Book book = new Book();
        book.setBookAuthorAndName("test test");
        return book;
//        return Response.status(201).entity(book).build();
    }

    private void populateBooks() {
        for (int i = 0; i < 5; i++) {
            BookCrud.addBook(createBook(i));
        }
    }

    private Book createBook(int num) {
        Book book = new Book();
        book.setBookAuthorAndName("Book - " + num);
        return book;
    }

}
