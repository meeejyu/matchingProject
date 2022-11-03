package com.mypetlikeit.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;

@Mapper
public interface MemberMapper {
    
    List<Member> getMemberList();

    void memberSave(Member member);
    
    void authoritySave(Authority authority);

    // void memberSave(MemberInsertDto memberInsertDto);

    List<Member> memberLoginId(String id);

    List<Member> memberNickname(String nickname);
    
}
