package com.boram.life.admin.controller;

import com.boram.life.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    public AdminController (AdminService adminService) {

        this.adminService = adminService;

    }

    @GetMapping("/register-member")
    public String registerMember(){

        return "content/admin/RegisterMember";

    }

}
