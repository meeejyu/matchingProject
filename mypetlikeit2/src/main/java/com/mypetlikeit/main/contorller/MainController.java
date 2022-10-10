package com.mypetlikeit.main.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.main.service.MainService;
import com.mypetlikeit.main.serviceImpl.MainServiceImpl;

@Controller
@RequestMapping(value = "/")
public class MainController {
    
    @Autowired
    private MainServiceImpl mainService;

    @GetMapping("/")
    // @GetMapping("/main")
    public String main() {
        System.out.println("되니?");
        List<Member> memberList = mainService.getMemberList();
        System.out.println("되니?2");

        System.out.println(memberList.toString());
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp";
    }

}
