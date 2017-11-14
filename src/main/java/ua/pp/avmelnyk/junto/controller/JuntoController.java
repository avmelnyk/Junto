package ua.pp.avmelnyk.junto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.junto.DAO.UserServiceImpl;
import ua.pp.avmelnyk.junto.model.Book;
import ua.pp.avmelnyk.junto.model.User;

@Controller
public class JuntoController {
    private UserServiceImpl userService;

    @Autowired
    public JuntoController(UserServiceImpl userService) {
        this.userService = userService;
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
    public String editUser(@PathVariable("id")Long userID, Model model){
        User user = userService.getUser(userID);
        model.addAttribute(user);
        return "editUser";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/user/"+user.getUserID().toString();
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(){
        return"books";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id")int book_id, Model model){
        Book book;
        return "book";
    }

}
