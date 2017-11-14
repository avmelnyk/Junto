package ua.pp.avmelnyk.junto.DAO;

import ua.pp.avmelnyk.junto.model.User;
import java.util.List;

public interface UserDAO {

     Long createUser(User user);

     User getUser(Long user_id);

     void updateUser( User user);

     void removeUser(Long user_id);

     List<User>listUsers();
}
