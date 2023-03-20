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
    public String registerMember(Authentication authentication, Model model){

        // 유저 아이디 가져오기
        String userId = authentication.getName();

        model.addAttribute("userId", userId);

        return "content/admin/RegisterMember";

    }

    @PostMapping("/register-member")
    public String registerMember(@ModelAttribute("essential") EssentialMemberInfoDTO eMemberInfo, @ModelAttribute("additional") AdditionalMemberInfoDTO aMemberInfo
            , RedirectAttributes rttr) {

        log.info("[AdminController] HTML 폼에서 넘어온 값 확인 ===================================");
        log.info("[AdminController] 필수정보(essential) eMemberInfo : " + eMemberInfo);
        log.info("[AdminController] 부가정보(additional) aMemberInfo : " + aMemberInfo);

        // 추가 정보 확인값
        boolean checkAdditionalInfo = false;

        // 트랜잭션 결과값
        int result = 0;

        // 1. 필수 정보로 회원 가입
        if(checkAdditionalInfo==false && eMemberInfo!=null){

            result = adminService.registerMember(eMemberInfo);

        }

        // 2. 추가 정보로 회원정보 추가 : 추가 정보 (aMemberInfo)에 값이 있는지 확인
        if(aMemberInfo.getMemberId()!=null){

            if(aMemberInfo.getMemberEmail()!=null || aMemberInfo.getMemberAddress()!=null || aMemberInfo.getMemberIntroduction()!=null){
                checkAdditionalInfo = true;
            }
        }

        // 2-1. 추가 정보 추가
        if(checkAdditionalInfo==true && eMemberInfo!=null){

            result = adminService.registerMember(eMemberInfo, aMemberInfo);

        }

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

        log.info("[AdminController] 사진 등록 프로세스 시작 ======================================");
        log.info("[AdminController] 사진 등록 대상 유저 정보 : " + pictureDTO);
        log.info("[AdminController] 등록할 사진 정보 : " + memberPicture);

        fileUploadService.uploadPicture(pictureDTO, memberPicture);

        return pictureDTO.getPictureUrl();

    }


}
