package com.boram.life.main.controller;

import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberRepository memberRepository;

    @GetMapping(value = {"/", "/main"})
    public ModelAndView defaultLocation(Authentication authentication, ModelAndView mv) {

        // 근태 상태 가져오기
//        근태 = 근태Service.select멤버근태;
//        mv.addObject("근태", 근태);

        // 결재 리스트 가져오기
//        List<결재> 결재목록 = 결재Service.select결재목록();
//        mv.addObject("결재목록", 결재목록);

        // 공지사항 가져오기
//        List<공지> 공지목록 = 공지Service.select최근공지();
//        mv.addObject("공지목록", 공지목록);

        // 멤버의 '권한명', '이름'을 가져오기
        System.out.println("authentication = " + authentication.getName());
        String name = memberRepository.findByMemberId(String.valueOf(authentication.getName())).get().getMemberName();
        String role = memberRepository.findByMemberId(String.valueOf(authentication.getName())).get().getAuthorities().getAuthContent();

        mv.addObject("userName", name);
        System.out.println("name = " + name);
        mv.addObject("userRole", role);
        System.out.println("role = " + role);

        // 뷰네임을 페이지로 지정 후 모델앤뷰 리턴
        mv.setViewName("/index");

        return mv;
    }


    @PostMapping("/")

    public String redirectMain() {

        return "redirect:/";
    }


}