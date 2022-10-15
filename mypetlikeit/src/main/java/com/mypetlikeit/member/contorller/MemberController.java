package com.mypetlikeit.member.contorller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

// 회원 관련 매핑
@Controller
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;

    @GetMapping("/member")
    public String member() {
        System.out.println("여기 오니?");
        List<Member> memberList = memberService.getMemberList();

        System.out.println(memberList.toString());
        return "main";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/signup")
    public String signUp_insert(Member member) {
        
        System.out.println("값이 잘오나 확인"+member.toString());
        memberService.memberSave(member);
        System.out.println("성공");
        return "signUpSuccess";
    }
}
