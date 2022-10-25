package com.mypetlikeit.member.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypetlikeit.comm.exception.ErrorResponse;
import com.mypetlikeit.comm.validation.ValidationSequence;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

// 회원 관련 매핑
@Controller
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;

    private ErrorResponse errorResponse;

    @GetMapping("/member")
    public String member() {
        System.out.println("여기 오니?");
        List<Member> memberList = memberService.getMemberList();

        System.out.println(memberList.toString());
        return "main";
    }

    @GetMapping("/signup")
    public String signUp() {
        // model.addAttribute("memberInsertDto", null);
        return "signUp";
    }

    @PostMapping("/signup/check")
    public @ResponseBody Map<String, Object> signUp_check(@Validated(ValidationSequence.class) MemberInsertDto memberInsertDto, BindingResult bindingResult) {
    // public @ResponseBody Map<String, Object> signUp_check(@Validated(ValidationSequence.class) MemberInsertDto memberInsertDto, Model model, BindingResult bindingResult) {

        Map<String, Object> resultMap = new HashMap<>();

        System.out.println("멤버 가져오기 : "+ memberInsertDto.toString());
        
        if(bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            
            for(ObjectError error : errors) {
                
                FieldError err = (FieldError) error;
                resultMap.put("fail", "실패");
                resultMap.put("valid_" + err.getField(), error.getDefaultMessage());
            }
            return resultMap;
        }
        else {
            // member PetYN 값을 통해 이름과 펫종류 예외 처리
            if(memberInsertDto.getPetYN().equals("Y")) {
                if(memberInsertDto.getPetName()==null) {
                    resultMap.put("fail", "펫 이름을 입력하지 않았습니다.");
                    return resultMap;
                };
                if(memberInsertDto.getPetCategory()==null) {
                    resultMap.put("fail", "펫 종류를 입력하지 않았습니다.");
                    return resultMap;
                };
            }
            
            System.out.println("값이 잘오나 확인"+memberInsertDto.toString());
            resultMap.put("success", "회원가입 성공");
            System.out.println("성공");
            return resultMap;
        }
    }

    @PostMapping("/signup/success")
    public String signUp_success(@Validated(ValidationSequence.class) MemberInsertDto memberInsertDto, BindingResult bindingResult, Model model) {

        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> errorMap = new HashMap<>();

        model.addAttribute("memberInsertDto", memberInsertDto);

        if(bindingResult.hasErrors()) {
            // for(FieldError error : bindingResult.getFieldError()) {

            // }
            // System.out.println("바인딩 에러 요놈 잡았다1 : "+bindingResult.getAllErrors().toString());
            List<ObjectError> errors = bindingResult.getAllErrors();
            
            // System.out.println("필드 나와라 : "+ bindingResult.getFieldError());
            for(ObjectError error : errors) {
                
                FieldError err = (FieldError) error;
                // System.out.println("일단 코드 : "+err.getField());
                // System.out.println("일단 메시지 : "+error.getDefaultMessage());

                // errorMap.put("valid_" + err.getField(), error.getDefaultMessage());
                model.addAttribute("valid_" + err.getField(), error.getDefaultMessage());
            }
            return "signUp";
        }
        else {
            // member PetYN 값을 통해 이름과 펫종류 예외 처리
            if(memberInsertDto.getPetYN().equals("Y")) {
                if(memberInsertDto.getPetName()==null) {
                    resultMap.put("fail", "펫 이름을 입력하지 않았습니다.");
                    return "signUp";
                };
                if(memberInsertDto.getPetCategory()==null) {
                    resultMap.put("fail", "펫 종류를 입력하지 않았습니다.");
                    return "signUp";
                };
            }
            
            System.out.println("값이 잘오나 확인"+memberInsertDto.toString());
            resultMap.put("success", "회원가입 성공");
            System.out.println("성공");
            return "signUp";
        }

        // memberService.memberSave(member);
        // return "signUpSuccess";
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
