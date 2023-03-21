package com.boram.life.main.controller;

import com.boram.life.domain.Member;
import com.boram.life.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    private final Logger log = LoggerFactory.getLogger(LoginService.class);

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
    @PostMapping("/login/do")
    public String loginPost(String username, String password, Model model, RedirectAttributes rttr) {

        log.info("[LoginController] 받은 값 : " + username + " / " + password);
        System.out.println("[LoginController] 받은 값 : " + username + " / " + password);

        // 로그인 처리
        boolean result = loginService.loginProcessing(Long.parseLong(username), password);
        log.info("[LoginController] 로그인 시도 결과 : " + result);
        System.out.println("[LoginController] 로그인 시도 결과 : " + result);

        if (result == true) {
            model.addAttribute("userId", username);
            return "redirect:/index";
        } else {
//            model.addAttribute("loginFail", true);
            rttr.addFlashAttribute("loginFail", "아이디, 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 스프링 시큐리티 기본 제공 메소드(logout)를 사용한 로그아웃 처리
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/index";
    }

}
