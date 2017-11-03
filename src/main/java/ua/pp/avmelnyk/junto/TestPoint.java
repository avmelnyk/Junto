package ua.pp.avmelnyk.junto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.model.User;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;

public class TestPoint {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = new User("username", "password", "filename","","");
        Long userId = (Long) session.save(user);
        System.out.println(userId.toString());
        tx.commit();
        session.close();

    }
}
