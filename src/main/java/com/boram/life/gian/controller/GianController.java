package com.boram.life.gian.controller;

import com.boram.life.gian.dto.GianDTO;
import com.boram.life.gian.service.GianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/gian")
public class GianController {

    private static final Logger log = LoggerFactory.getLogger(GianController.class);

    private final GianService gianService;

    public GianController(GianService gianService){ this.gianService = gianService;}

    @GetMapping("/position-gian")
    public String goPositionGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "PositionGian";
    }

    @GetMapping("/promotion-gian")
    public String goPromotionGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "PromotionGian";
    }

    @GetMapping("/punishment-gian")
    public String goPunishmentGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "PunishmentGian";
    }

    @GetMapping("/common-gian")
    public String goCommonGian(Authentication authentication, Model model){
        long userId = Long.parseLong(authentication.getName());
        model.addAttribute("userId", gianService.selectUserTag(userId));
        return "GianWithoutForm";
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
