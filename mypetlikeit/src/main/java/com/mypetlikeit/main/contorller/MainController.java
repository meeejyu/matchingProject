package com.mypetlikeit.main.contorller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.main.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class MainController {
    
    private final MainService mainService;

    @GetMapping("/")
    // @GetMapping("/main")
    public String main() {
        System.out.println("되니?");
        System.out.println("되니?2");

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
