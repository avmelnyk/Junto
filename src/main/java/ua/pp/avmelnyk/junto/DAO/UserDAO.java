package ua.pp.avmelnyk.junto.DAO;

import ua.pp.avmelnyk.junto.model.User;
import java.util.List;

public interface UserDAO {

     void createUser(String username, String password, String firstname, String lastname, String email);

     User getUser(Long user_id);

     User updateUser(Long user_id, User user);

     void removeUser(Long user_id);

     List<User>listUsers();
}
