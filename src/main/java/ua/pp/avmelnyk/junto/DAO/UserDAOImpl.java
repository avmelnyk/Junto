package ua.pp.avmelnyk.junto.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.model.User;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    private Session session;

    public UserDAOImpl(Session session) {
        this.session = session;
    }

    public Long createUser(User user) {
        try {
            Transaction tx = session.beginTransaction();
            Long user_id = (Long) session.save(user);
            tx.commit();
            return user_id;
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
        }
        return null;
    }

    public User getUser(Long user_id) {
        Transaction tx = session.beginTransaction();
        User user = (User) session.load(User.class, user_id);
        tx.commit();
        return user;
    }

    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();
        User merged = (User)session.merge(user);
        session.saveOrUpdate(merged);
        tx.commit();
    }

    public void removeUser(Long user_id) {
        Transaction tx = session.beginTransaction();
        User user  = (User) session.load(User.class, user_id);
        if(user != null){
            session.delete(user);
        }
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User>users = null;
        try {
            Transaction tx = session.beginTransaction();
            users = session.createCriteria(User.class).list();
            tx.commit();
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
        }
        return users;
    }
}
