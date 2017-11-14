package ua.pp.avmelnyk.junto.DAO;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.junto.model.User;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    public UserServiceImpl() {
        setUserDAO();
    }
    private  void setUserDAO(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.userDAO = new UserDAOImpl(session);
    }


    public Long createUser(User user) {
        return  this.userDAO.createUser(user);

    }

    public User getUser(Long user_id) {
        return  this.userDAO.getUser(user_id);
    }

    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    public void removeUser(Long user_id) {
        this.userDAO.removeUser(user_id);
    }

    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }
}
