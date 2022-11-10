package com.mypetlikeit.member.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypetlikeit.comm.validation.ValidationSequence;
import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

// 회원 관련 매핑
@Controller
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;

    @GetMapping("/member")
    public String member() {
        List<Map<String, Object>> memberMap = memberService.getMemberList();

        System.out.println(memberMap.toString());
        return "main";
    }

    @GetMapping("/signup")
    public String signUp() {

        return "signUp";
    }

    @PostMapping("/signup/check")
    public @ResponseBody Map<String, Object> signUp_check(@Valid MemberInsertDto memberInsertDto, BindingResult bindingResult, Errors errorss) {

        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        System.out.println("멤버 가져오기 : "+ memberInsertDto.toString());

        if(errorss.hasFieldErrors()) {
            for(FieldError fieldError : errorss.getFieldErrors()) {
                if(resultMap.containsKey("valid_"+fieldError.getField())) {
                    if(!resultMap.get("valid_"+fieldError.getField()).toString().contains("1")) {
                        resultMap.put("valid_"+fieldError.getField(), fieldError.getDefaultMessage());
                    }
                }
                else {
                    resultMap.put("valid_"+fieldError.getField(), fieldError.getDefaultMessage());
                }
                result.put("valid_"+fieldError.getField(), fieldError.getDefaultMessage());
            }
            resultMap.put("fail", "실패");
        }

        // petYN 값에 따른 처리
        if(memberInsertDto.getPetYN()!=null) {
            if(memberInsertDto.getPetYN().equals("Y")) {
                if(memberInsertDto.getPetName()==null || memberInsertDto.getPetName().equals("")) {
                    resultMap.put("valid_petName", "petName_chk1");
                }
                else {
                    System.out.println("패턴 확인 : " + Pattern.matches("^[a-z가-힣]{1,20}$", memberInsertDto.getPetName()));
                    if(Pattern.matches("^[a-z가-힣]{1,20}$", memberInsertDto.getPetName())==false) {
                        resultMap.put("valid_petName", "petName_chk2");
                    };
                }
                if(memberInsertDto.getPetCategory()==null) {
                    resultMap.put("valid_petCategory", "petCategory_chk1");
                };
                resultMap.put("fail", "실패");
            }
        }
        if(resultMap.containsKey("valid_password")==false && resultMap.containsKey("valid_more_password")==false) {
            if(memberInsertDto.getPassword().equals(memberInsertDto.getMore_password())==false) {
                resultMap.put("valid_more_password", "pw_more_chk2");
                resultMap.put("fail", "실패");
            }
        }
        if(resultMap.containsKey("fail")==false) {
            resultMap.put("success", "회원가입 성공");
            System.out.println("성공");
        }
        return resultMap;
    }

    // 비밀번호 암호화에 따른 비밀번호 길이 변경 필요
    @PostMapping("/signup/success")
    public String signUp_success(@Valid MemberInsertDto memberInsertDto, BindingResult bindingResult, Model model) {

        memberInsertDto.encryptionPass(memberInsertDto);

        memberService.memberSave(memberInsertDto);

        System.out.println("일단은 디티오 잘 갖고 오겠지?"+memberInsertDto.getLoginId());

        Map<String,Object> memberMap = memberService.memberLoginId(memberInsertDto.getLoginId());

        System.out.println("리스트를 찍어봅시다11"+memberMap.toString());
        
        Authority authority = Authority.ofUser((Long.valueOf(memberMap.get("MEMBER_ID").toString())));

        memberService.authoritySave(authority);
        
        return "signUpSuccess";
    }

    @PostMapping("/member/idCheck")
    public @ResponseBody String memberidCheck(String LOGIN_ID) {
        
        System.out.println("값이 잘오나 확인"+LOGIN_ID);
        Map<String,Object> memberMap = memberService.memberLoginId(LOGIN_ID);


        if(memberMap==null) {
            System.out.println("성공");
            return "success";            
        }
        else {
            Map<String,Object> memberMap2 = memberService.memberUsername(memberMap.get("MEMBER_USERNAME").toString());
            System.out.println("map 값 확인 : "+ memberMap2.toString());
            System.out.println("실패");
            return "fail";
        }
    }

    @PostMapping("/member/nickCheck")
    public @ResponseBody String memberNickCheck(String nickname) {
        
        System.out.println("값이 잘오나 확인"+nickname);
        Map<String,Object> memberMap = memberService.memberNickname(nickname);
        if(memberMap==null) {
            System.out.println("성공");
            return "success";
        }
        else {
            System.out.println("실패");
            return "fail";
        }
    }
}
