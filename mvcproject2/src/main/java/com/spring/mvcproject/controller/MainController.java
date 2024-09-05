package com.spring.mvcproject.controller;

import com.spring.mvcproject.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) { // 오토와이어링
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String mainPage(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if( logout!=null ) { // logout 매개변수가 있다면
            loggedUserManagementService.setUserName(null);
            return "redirect:/user/login";
        }

        String userName = loggedUserManagementService.getUserName();

        if(userName == null) {
            return "redirect:/user/login"; //로그인이 안됐으면 로그인 페이지로 리다이렉트
        }

        model.addAttribute("userName", userName);
        return "main";
    }
}
