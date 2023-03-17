package com.boram.life.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public ModelAndView defaultLocation(ModelAndView mv) {

        // 근태 상태 가져오기
//        근태 = 근태Service.select멤버근태;
//        mv.addObject("근태", 근태);

        // 결재 리스트 가져오기
//        List<결재> 결재목록 = 결재Service.select결재목록();
//        mv.addObject("결재목록", 결재목록);

        // 공지사항 가져오기
//        List<공지> 공지목록 = 공지Service.select최근공지();
//        mv.addObject("공지목록", 공지목록);

        // 뷰네임을 페이지로 지정 후 모델앤뷰 리턴
        mv.setViewName("/index");

        return mv;
    }

    @PostMapping("/")

    public String redirectMain() {

        return "redirect:/";
    }


}