package com.mypetlikeit.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mypetlikeit.domain.Member;

@Mapper
public interface MemberMapper {
    
    List<Member> getMemberList();
    
}
