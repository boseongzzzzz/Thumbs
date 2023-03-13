package com.boram.life.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public void login(){

    }
    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/index")
    public String showIndex(){
        return "/index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}
