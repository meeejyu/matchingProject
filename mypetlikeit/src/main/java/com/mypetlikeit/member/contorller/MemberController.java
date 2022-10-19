package com.mypetlikeit.member.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/signup/success")
    public Map<String, Object> signUp_success(Member member) {
        
        Map<String, Object> resultMap = new HashMap<>();
        // 회원가입 유효성 검증 추가
        // member
        if(member.getPetYN().equals("Y")) {
            if(member.getPetName()==null) {
                resultMap.put("fail", "펫 이름을 입력하지 않았습니다.");
                return resultMap;
            };
            if(member.getPetCategory()==null) {
                resultMap.put("fail", "펫 종류를 입력하지 않았습니다.");
                return resultMap;
            };
        }

        System.out.println("값이 잘오나 확인"+member.toString());
        memberService.memberSave(member);
        resultMap.put("success", "회원가입 성공");
        System.out.println("성공");
        return resultMap;
    }

    @PostMapping("/member/idCheck")
    public @ResponseBody String memberidCheck(String LOGIN_ID) {
        
        System.out.println("값이 잘오나 확인"+LOGIN_ID);
        List<Member> member = memberService.memberLoginId(LOGIN_ID);
        if(member.size()<1) {
            System.out.println("성공");
            return "success";
        }
        else {
            System.out.println("실패");
            return "fail";
        }
        // return "signUpSuccess";
    }

    @PostMapping("/member/nickCheck")
    public @ResponseBody String memberNickCheck(String nickname) {
        
        System.out.println("값이 잘오나 확인"+nickname);
        List<Member> member = memberService.memberNickname(nickname);
        if(member.size()<1) {
            System.out.println("성공");
            return "success";
        }
        else {
            System.out.println("실패");
            return "fail";
        }
        // return "signUpSuccess";
    }
}
