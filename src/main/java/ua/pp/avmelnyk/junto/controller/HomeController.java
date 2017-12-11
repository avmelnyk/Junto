package ua.pp.avmelnyk.junto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String getHomePage(){
            return "index";
        }

        @RequestMapping(value = "login",method = RequestMethod.GET)
        public String loginPage(Model model){
            return "login";
        }
}
