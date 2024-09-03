package com.spring.mvcproject.controller;

import com.spring.mvcproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/user/signup
    @RequestMapping("/signup") // GET
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

//    @RequestMapping(value="/signup", method= RequestMethod.POST)
//    @ResponseBody
//    public String signup(@ModelAttribute User user) {
//        System.out.println("user = " + user);
//        return "success";
//    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signup(@ModelAttribute User user) {
        System.out.println("user = " + user);
        //return "redirect:/user/signup";
        return "redirect:http://localhost:8080/user/signup";
    }
}
