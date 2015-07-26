package miko.test.project.crud;

import miko.test.project.entity.Book;
import miko.test.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mykola.kozhemiaka on 26.07.2015.
 */
public final class BookCrud {

    private BookCrud() {}

    public static void addBook(Book book) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            books = session.createQuery("from Book").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return books;
    }

}
