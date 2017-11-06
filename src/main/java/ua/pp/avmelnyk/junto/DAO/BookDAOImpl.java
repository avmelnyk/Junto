package ua.pp.avmelnyk.junto.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.model.Book;
import java.util.List;

public class BookDAOImpl implements BookDAO{

    private Session session;

    public BookDAOImpl(Session session) {
        this.session = session;
    }

    public void createBook(String name, String author, Long ISBN, String genre) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(new Book(name, author,ISBN, genre));
            tx.commit();

        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
        }
    }

    public Book getBook(Long book_id) {
        Transaction tx = session.beginTransaction();
        Book book = (Book)session.load(Book.class, book_id);
        tx.commit();
        return book;
    }

    public void updateBook(Book book) {
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();

    }

    public void removeBook(Long book_id) {
        Transaction tx  = session.beginTransaction();
        Book book = (Book)session.load(Book.class, book_id);
        if(book != null){
            session.delete(book);
        }
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        List<Book> bookList = null;
        Transaction tx = session.beginTransaction();
         try {
             bookList = session.createCriteria(Book.class).list();
             tx.commit();
         }

         catch (RuntimeException e){
             session.getTransaction().rollback();
         }

        return bookList;

    }
}
