package ua.pp.avmelnyk.junto.DAO;

import ua.pp.avmelnyk.junto.model.Book;

import java.util.List;

public interface BookService {
    Long createBook(Book book);
    Book getBook(Long book_id);
    void updateBook(Book book);
    void removeBook(Long book_id);
    List<Book> listBooks();
}
