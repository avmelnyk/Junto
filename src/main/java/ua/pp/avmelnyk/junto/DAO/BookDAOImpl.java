package ua.pp.avmelnyk.junto.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;

import java.util.List;

public class BookDAOImpl implements BookDAO{

    private Session session;

    public BookDAOImpl(Session session) {
        this.session = session;
    }

    public Long createBook(Book book) {
        try {
            Transaction tx = session.beginTransaction();
            Long book_id = (Long)session.save(book);
            tx.commit();
            return book_id;
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
        }
        return null;
    }

    public Book getBook(Long book_id) {
        Transaction tx = session.beginTransaction();
        Book book = (Book)session.load(Book.class, book_id);
        tx.commit();
        return book;
    }

    public void updateBook(Book book) {
        Transaction tx = session.beginTransaction();
        Book merged = (Book)session.merge(book);
        session.update(merged);
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
             try {
                 Transaction tx = session.beginTransaction();
                 bookList = session.createCriteria(Book.class).list();
                 tx.commit();
             }
             catch (RuntimeException e){
                 session.getTransaction().rollback();
             }
        return bookList;

    }
}
