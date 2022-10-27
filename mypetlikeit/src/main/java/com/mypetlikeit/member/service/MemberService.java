package com.mypetlikeit.member.service;

import java.util.List;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;

public interface MemberService {
    
    public List<Member> getMemberList();

    // void memberSave(Member member);

    void memberSave(MemberInsertDto memberInsertDto);

    List<Member> memberLoginId(String id);

    List<Member> memberNickname(String nickname);

}
