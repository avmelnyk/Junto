package ua.pp.avmelnyk.junto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.DAO.UserDAOImpl;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class TestPoint {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserDAOImpl userDAO = new UserDAOImpl(session);
        /*Transaction tx = session.beginTransaction();
        User user = new User("avmelnyk", "password", "Andrii","Melnyk","email");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", "J.K. Rowling", new Long(123123123), "fantasy"));
        user.setBookList(bookList);
        Long userId = (Long) session.save(user);
        System.out.println(userId.toString());
        User user = (User) session.load(User.class, new Long(1));
        System.out.println(user.toString());
        tx.commit();
        session.close();
        userDAO.createUser("avmelnyk", "password", "Andrii","Melnyk","email");
        userDAO.createUser("avmelnyk", "password", "Dima","Melnyk","email");
        userDAO.createUser("avmelnyk", "password", "Pasha","Melnyk","email");*/
        List<User> users = userDAO.listUsers();
        for (User user: users
             ) {
            System.out.println(user.toString());
        }

    }
}
