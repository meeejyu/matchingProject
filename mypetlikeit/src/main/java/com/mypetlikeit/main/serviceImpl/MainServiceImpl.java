package com.mypetlikeit.main.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.main.service.MainService;

@Service
public class MainServiceImpl{

    // private SqlSession seqlSession;
    MainService mainService;

    public List<Member> getMemberList() {
        System.out.println("여기는 impl 응답하라");
        return mainService.getMemberList();
    }
    
}
