package com.mypetlikeit.member.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;
import com.mypetlikeit.member.mapper.MemberMapper;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberMapper memberMapper;

    @Override
    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    // @Override
    // public void memberSave(Member member) {
    //     memberMapper.memberSave(member);
    // }

    @Override
    public List<Member> memberLoginId(String id) {
        List<Member> member = memberMapper.memberLoginId(id);        
        return member;
    }

    @Override
    public List<Member> memberNickname(String nickname) {
        List<Member> member = memberMapper.memberNickname(nickname);        
        return member;
    }

    @Override
    public void memberSave(MemberInsertDto memberInsertDto) {
        memberMapper.memberSave(Member.ofUser(memberInsertDto));  
    }

    @Override
    public void authoritySave(Authority authority) {
        memberMapper.authoritySave(authority);        
    }



}
