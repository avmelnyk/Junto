package ua.pp.avmelnyk.junto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.junto.model.User;

@Controller
public class JuntoController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable("id")int user_id, Model model){
        //User user = null;
        //model.addAttribute(user);
        return "user";
    }
}
