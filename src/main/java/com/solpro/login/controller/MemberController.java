package com.solpro.login.controller;

import com.solpro.login.domain.Member;
import com.solpro.login.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    private final MemberMapper mapper;

    public MemberController(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/login")
    public String getLogin() {

        return "member/home";
    }

    @GetMapping("/memberShip")
    public String getMemberShip() {

        return "member/memberShip";
    }

    @GetMapping("/memberCheck")
    public @ResponseBody int memberCheck(@RequestParam("memId") String memId) {

        Member m = mapper.registerCheck(memId);
        if (m != null) {
            return 0;
        } else if (memId.equals("")) {
            return 1;
        } else {
            return 2;
        }
    }

    @GetMapping("/memberRegister")
    public String memberRegister(Member member, RedirectAttributes redirectAttributes, HttpSession session) {
        if (member.getMemId() == null || member.getMemId().equals("") ||
                member.getMemPassword() == null || member.getMemPassword().equals("") ||
                member.getMemName() == null || member.getMemName().equals("") ||
                member.getMemEmail() == null || member.getMemEmail().equals("")) {
            redirectAttributes.addFlashAttribute("msgType", "실패 메시지");
            redirectAttributes.addFlashAttribute("msg", "모든 내용을 입력하세요.");
            return "redirect:/memberShip";
        }
        int result = mapper.register(member);
        if (result == 1) { //성공
            redirectAttributes.addFlashAttribute("msgType", "성공 메시지");
            redirectAttributes.addFlashAttribute("msg", "회원가입에 성공했습니다.");
            session.setAttribute("mvo", member); // ${empty member 체크}
            return "redirect:/";

        } else { //실패
            redirectAttributes.addFlashAttribute("msgType", "실패 메세지");
            redirectAttributes.addFlashAttribute("msg", "이미 존재하는 회원입니다.");
            return "redirect:/memberShip";
        }
    }
}
