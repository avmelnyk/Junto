package ua.pp.avmelnyk.junto.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long bookID;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "ISBN")
    private Long ISBN;
    @Column(name = "GENRE")
    private String genre;

    @ManyToMany
    private List<User> owners;

    public Book() {
    }

    public Book(String name, String author, Long ISBN, String genre) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Long getBookID() {
        return bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<User> getOwners() {
        return owners;
    }

    public void setOwners(List<User> owners) {
        this.owners = owners;
    }
}
