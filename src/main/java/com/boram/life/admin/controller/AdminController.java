package com.boram.life.admin.controller;

import com.boram.life.admin.dto.AdditionalMemberInfoDTO;
import com.boram.life.admin.dto.EssentialMemberInfoDTO;
import com.boram.life.admin.dto.PictureDTO;
import com.boram.life.admin.service.AdminService;
import com.boram.life.api.fileUpload.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.UUID;

import static java.lang.Boolean.valueOf;

@Controller
@RequestMapping("/manage")
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    private final FileUploadService fileUploadService;

    public AdminController (AdminService adminService, FileUploadService fileUploadService) {

        this.adminService = adminService;
        this.fileUploadService = fileUploadService;

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

    @PostMapping("/register-member")
    public String registerMember(@ModelAttribute("essential") EssentialMemberInfoDTO eMemberInfo, @ModelAttribute("additional") AdditionalMemberInfoDTO aMemberInfo
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

        return "redirect:/manage/register-member";
    }

    @PostMapping("/register-member/addPicture")
    public String addPicture(@ModelAttribute PictureDTO pictureDTO, @RequestParam("file") MultipartFile memberPicture){

        fileUploadService.uploadPicture(pictureDTO, memberPicture);

        return pictureDTO.getPictureUrl();

    }


}
