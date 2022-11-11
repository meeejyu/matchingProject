package com.mypetlikeit.main.contorller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypetlikeit.domain.LoginDto;
import com.mypetlikeit.main.service.MainService;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
// @RequestMapping(value = "/")
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;
    
    // private final MainService mainService;

    // @GetMapping("/")
    @GetMapping("/main")
    public String main() {

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login/check")
    public @ResponseBody Map<String, Object> loginCheck(LoginDto loginDto) {

        Map<String, Object> resultMap = new HashMap<>();

        loginDto.encryptionPass(loginDto);

        Map<String, Object> memberMap = memberService.getLoginMember(loginDto);

        if(memberMap==null) {
            resultMap.put("fail", "아이디, 비밀번호를 다시 확인해주세요.");
        }
        else {
            return memberMap;
        }
        return resultMap;
    }

    @GetMapping("/user/main")
    public String userMain() {
        System.out.println("추카 포카");
        return "userMain";
    }

}
