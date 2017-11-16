package ua.pp.avmelnyk.junto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.junto.DAO.BookServiceImpl;
import ua.pp.avmelnyk.junto.DAO.UserServiceImpl;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JuntoController {
    private UserServiceImpl userService;
    private BookServiceImpl bookService;

    @Autowired
    public JuntoController(UserServiceImpl userService, BookServiceImpl bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable("id")Long user_id, Model model){
        User user = userService.getUser(user_id);
        model.addAttribute(user);
        return "user";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(Model model){
        User user = new User();
        model.addAttribute(user);
        return "registration";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("user") User user){
        Long user_ID = userService.createUser(user);
        return "redirect:/user/"+user_ID.toString();
    }
    @RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
    public String getEditUserForm(@PathVariable("id")Long userID, Model model){
        User user = userService.getUser(userID);
        model.addAttribute(user);
        return "editUser";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/user/"+user.getUserID().toString();
    }

    @RequestMapping(value = "/user/{id}/book", method = RequestMethod.GET)
    public String getAddBookForm(@PathVariable("id")Long userID, Model model){
        User user = userService.getUser(userID);
        Book book = new Book();
        model.addAttribute(user);
        model.addAttribute(book);
        return "addNewBook";
    }
    @RequestMapping(value = "user/{id}/book", method = RequestMethod.POST)
    public String addNewBook(@PathVariable("id")Long userID, @ModelAttribute("book") Book book){
        User user = userService.getUser(userID);
        List<User>owners = new ArrayList<User>();
        book.setOwners(owners);
        book.getOwners().add(user);
        user.getBookList().add(book);
        userService.updateUser(user);
        return "redirect:/user/"+userID;

    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model){
        List<Book> bookList = bookService.listBooks();
        model.addAttribute(bookList);
        return"books";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id")Long book_id, Model model){
        Book book = bookService.getBook(book_id);
        System.out.println(book.getOwners().size());
        model.addAttribute(book);
        return "/book";
    }

}
