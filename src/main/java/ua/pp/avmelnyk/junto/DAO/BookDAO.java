package ua.pp.avmelnyk.junto.DAO;

import ua.pp.avmelnyk.junto.model.Book;
import java.util.List;

public interface BookDAO {
    void createBook(String name, String author, Long ISBN, String genre);
    Book getBook(Long book_id);
    void updateBook(Book book);
    void removeBook(Long book_id);
    List<Book> listBooks();
}
