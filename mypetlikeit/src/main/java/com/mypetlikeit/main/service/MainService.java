package com.mypetlikeit.main.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mypetlikeit.domain.Member;

// import org.apache.ibatis.annotations.Mapper;

@Component
public @Mapper interface MainService {
    
    //xml방식
    List<Member> getMemberList();
    
}
