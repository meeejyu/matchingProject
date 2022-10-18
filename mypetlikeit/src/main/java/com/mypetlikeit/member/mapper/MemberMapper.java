package com.mypetlikeit.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mypetlikeit.domain.Member;

@Mapper
public interface MemberMapper {
    
    List<Member> getMemberList();

    void memberSave(Member member);

    List<Member> memberLoginId(String id);

    List<Member> memberNickname(String nickname);
    
}
