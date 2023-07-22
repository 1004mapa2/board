package com.solpro.login.controller;

import com.solpro.login.domain.LoginVO;
import com.solpro.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String getLogin() {

        return "home";
    }

    @PostMapping("/")
    public String PostLogin(Model model) {
        Object userId = model.getAttribute("userId");
        Object userPassword = model.getAttribute("userPassword");

        LoginVO loginVO = new LoginVO();
        loginVO.setUserId((String) userId);
        loginVO.setUserPassword((String) userPassword);



        return "board";
    }

    @GetMapping("/memberShip")
    public String getMemberShip() {

        return "memberShip";
    }

    @PostMapping("/memberShip")
    public String postMemberShip(LoginVO loginVO) {
        loginService.register(loginVO);

        return "home";
    }
}
