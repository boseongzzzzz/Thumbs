package com.boram.life.main.controller;

import com.boram.life.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public String loginPost(String username, String password) {
        // 로그인 처리
        return (loginService.loginProcessing(Long.parseLong(username), password)) ? "redirect:/index" : "/error";
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/index")
    public String showIndex(){
        return "/index";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 스프링 시큐리티 기본 제공 메소드(logout)를 사용한 로그아웃 처리
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/index";
    }

}
