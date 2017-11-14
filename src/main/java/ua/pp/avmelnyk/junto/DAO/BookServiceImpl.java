package ua.pp.avmelnyk.junto.DAO;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    public BookServiceImpl() {
        setBookDAO();
    }

    private void setBookDAO(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.bookDAO = new BookDAOImpl(session);
    }
    public Long createBook(Book book) {
        return  this.bookDAO.createBook(book);
    }

    public Book getBook(Long book_id) {
        return this.bookDAO.getBook(book_id);
    }

    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    public void removeBook(Long book_id) {
        this.bookDAO.removeBook(book_id);
    }

    public List<Book> listBooks() {
        return this.bookDAO.listBooks();
    }
}
