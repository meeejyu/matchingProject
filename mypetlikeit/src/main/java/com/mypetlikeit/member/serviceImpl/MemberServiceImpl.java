package com.mypetlikeit.member.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.member.mapper.MemberMapper;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberMapper memberMapper;

    @Override
    public List<Member> getMemberList() {
        System.out.println("여기는 impl 응답하라");
        return memberMapper.getMemberList();
    }

    @Override
    public void memberSave(Member member) {
        memberMapper.memberSave(member);
    }

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



}
