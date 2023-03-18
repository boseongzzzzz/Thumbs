package com.boram.life.admin.controller;

import com.boram.life.admin.dto.AdditionalMemberInfoDTO;
import com.boram.life.admin.dto.EssentialMemberInfoDTO;
import com.boram.life.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.Map;

import static java.lang.Boolean.valueOf;

@Controller
@RequestMapping("/manage")
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    public AdminController (AdminService adminService) {

        this.adminService = adminService;

    }

    @GetMapping("")
    public String adminMain (Authentication authentication, Model model){

        // 유저 아이디 가져오기
        String userId = authentication.getName();

        model.addAttribute("userId", userId);

        return "content/admin/AdminMain";
    }

    // 회원 등록(가입)
    @GetMapping("/register-member")
    public String registerMember(){

        return "content/admin/RegisterMember";

    }

    @PostMapping
    public String registerMember(@ModelAttribute EssentialMemberInfoDTO eMemberInfo, @ModelAttribute AdditionalMemberInfoDTO aMemberInfo
            , RedirectAttributes rttr) {

        // 필수 정보로 회원 가입
        int result = adminService.registerMember(eMemberInfo, aMemberInfo);

        if (result == 1) {

            rttr.addFlashAttribute("message", "회원 등록에 성공하였습니다! (추가 정보 제외)");

        } else if (result == 2) {

            rttr.addFlashAttribute("message", "회원 등록 및 추가 정보 입력 에 성공하였습니다!");

        } else {

            rttr.addFlashAttribute("message", "회원 등록에 실패하였습니다.");

        }

        return "redirect:/manage/register-member;";
    }

}
