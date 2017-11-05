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

    public void createUser(String username, String password, String firstname, String lastname, String email) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(new User(username, password, firstname, lastname, email));
            tx.commit();
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
        }
    }

    public User getUser(Long user_id) {
        Transaction tx = session.beginTransaction();
        User user = (User) session.load(User.class, user_id);
        tx.commit();
        return user;
    }

    public void updateUser( User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
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
