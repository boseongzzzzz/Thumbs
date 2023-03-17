package com.boram.life.gian.controller;

import com.boram.life.gian.dto.GianDTO;
import com.boram.life.gian.service.GianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/gian")
public class GianController {

    private static final Logger log = LoggerFactory.getLogger(GianController.class);

    private final GianService gianService;

    public GianController(GianService gianService){ this.gianService = gianService;}

    @GetMapping("/position-gian")
    public String goPositionGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "content/gian/PositionGian";
    }

    @GetMapping("/promotion-gian")
    public String goPromotionGian(Authentication authentication, Model model){
//        long userId = Long.parseLong(authentication.getName());
        long userId = 1L;
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "content/gian/PromotionGian";
    }

    @GetMapping("/punishment-gian")
    public String goPunishmentGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "content/gian/PunishmentGian";
    }

    @GetMapping("/common-gian")
    public ModelAndView goCommonGian(Authentication authentication, ModelAndView mv){

        // userId로 '부서'+'직급'+'이름'을 가져오기 : 로그인 시 id가 사번이 들어와야 하는데 user로만 로그인 가능해서 안됨
//        long userId = Long.parseLong(authentication.getName());   <-- 로그인 시 id로 "user"가 들어와서 NumberFormatException이 발생
//        log.info("[gianService] authentication.getName() : " + authentication.getName() );
//        mv.addObject("userId", gianService.selectUserTag(userId));

        // userId로 '부서'+'직급'+'이름'을 가져왔다고 가정하고 addOject
        mv.addObject("userId", "인사부 주임 김보성");

        // 조직도를 위한 조직 세팅


        mv.setViewName("content/gian/GianWithoutForm.html");

        return mv;
    }


    // 각 기안 폼에서, 값을 입력한 뒤 '기안시작'을 누르면 폼이 넘어간다.
    @RequestMapping(value = "/imsi-gian", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processDocument(Authentication authentication, @ModelAttribute GianDTO gianDTO, MultipartFile gianAttachments){

        ModelAndView mv = new ModelAndView();

        if((gianService.registGian(authentication, gianDTO, gianAttachments))instanceof String){

            mv.addObject("result", gianService.registGian(authentication, gianDTO, gianAttachments));
            mv.setViewName("alert");

        } else if ((gianService.registGian(authentication, gianDTO, gianAttachments))instanceof Number) {

            RedirectView redirectView = new RedirectView("/imsi-gian");
            mv.setView(redirectView);
        }

        return mv;

    }

}
