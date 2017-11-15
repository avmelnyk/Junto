package ua.pp.avmelnyk.junto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.junto.DAO.*;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;
import ua.pp.avmelnyk.junto.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

public class TestPoint {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BookService  bookService = new BookServiceImpl();
        /*User user = new User("username", "firstname", "lastname", "email", "password");
        Book book  = new Book("Harry Potter","J. K. Rowling", new Long(1233253), "fantasy");
        List<Book>bookList = new ArrayList<Book>();
        bookList.add(book);
        List<User>ownerslist = new ArrayList<User>();
        ownerslist.add(user);
        book.setOwners(ownerslist);
        user.setBookList(bookList);
        userService.createUser(user);
*/
        System.out.println(userService.getUser(new Long(2)).getBookList().toString());
        System.out.println(bookService.getBook(new Long(3)).getOwners().toString());


    }
}
