package com.solpro.login.controller;

import com.solpro.login.domain.Member;
import com.solpro.login.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberMapper mapper;

    public MemberController(MemberMapper mapper) {
        this.mapper = mapper;
    }

//    @GetMapping("/")
//    public String getLogin() {
//
//        return "member/home";
//    }

    @GetMapping("/memberShip")
    public String getMemberShip() {

        return "member/memberShip";
    }

    @GetMapping("/memberCheck")
    public @ResponseBody int memberCheck(@RequestParam("memId") String memId){

        Member m = mapper.registerCheck(memId);
        if(m != null){
            return 0;
        } else if(memId.equals("")) {
            return 1;
        } else {
            return 2;
        }
    }
}
