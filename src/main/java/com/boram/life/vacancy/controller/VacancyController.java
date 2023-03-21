package com.boram.life.vacancy.controller;

import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping(value = "/vacancy")
@RequiredArgsConstructor
public class VacancyController {


    @GetMapping("")
    public ResponseEntity<Resource> vacancySystemExample() throws IOException {
        Resource resource = new ClassPathResource("static/VacancySystem.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }

    @GetMapping("/asdf")
    public String defaultLocation() {
//    public ModelAndView defaultLocation(Authentication authentication, ModelAndView mv) {

//        // 멤버의 '권한명', '이름'을 가져오기
//        System.out.println("authentication = " + authentication.getName());
//        String name = memberRepository.findByMemberId(String.valueOf(authentication.getName())).get().getMemberName();
//        String role = memberRepository.findByMemberId(String.valueOf(authentication.getName())).get().getAuthorities().getAuthContent();
//
//        mv.addObject("userName", name);
//        System.out.println("name = " + name);
//        mv.addObject("userRole", role);
//        System.out.println("role = " + role);
//
//        // 뷰네임을 페이지로 지정 후 모델앤뷰 리턴
//        mv.setViewName("/content/vacancy/VacancySystem");
//
//        return mv;

        return null;
    }


    @PostMapping("/")

    public String redirectMain() {

        return "redirect:/";
    }


}