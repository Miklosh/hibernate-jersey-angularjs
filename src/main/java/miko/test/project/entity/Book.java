package miko.test.project.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by mykola.kozhemiaka on 26.07.2015.
 */

@Entity
@Table(name = "BOOK")
public class Book implements Serializable{

    @Id
    @GeneratedValue
    private long bookId;

    @Column
    private String bookAuthorAndName;

    public Book(){}

    public long getBookId() {
        return bookId;
    }

    public String getBookAuthorAndName() {
        return bookAuthorAndName;
    }

    public void setBookAuthorAndName(String bookAuthorAndName) {
        this.bookAuthorAndName = bookAuthorAndName;
    }
}
