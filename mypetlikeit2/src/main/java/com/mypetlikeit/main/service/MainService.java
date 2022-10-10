package com.mypetlikeit.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mypetlikeit.domain.Member;

@Mapper
public interface MainService {
    
    //xml방식
    List<Member> getMemberList();
    
}
