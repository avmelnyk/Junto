package ua.pp.avmelnyk.junto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class TestPoint {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = new User("avmelnyk", "password", "Andrii","Melnyk","email");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", "J.K. Rowling", new Long(123123123), "fantasy"));
        user.setBookList(bookList);
        Long userId = (Long) session.save(user);
        System.out.println(userId.toString());
        tx.commit();
        session.close();

    }
}
