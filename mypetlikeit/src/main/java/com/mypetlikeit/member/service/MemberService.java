package com.mypetlikeit.member.service;

import java.util.List;

import com.mypetlikeit.domain.Member;

public interface MemberService {
    
    public List<Member> getMemberList();

    void memberSave(Member member);

    List<Member> memberLoginId(String id);

    List<Member> memberNickname(String nickname);

}
