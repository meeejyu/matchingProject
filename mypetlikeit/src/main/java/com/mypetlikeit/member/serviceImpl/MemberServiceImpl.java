package com.mypetlikeit.member.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, Object>> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Override
    public Map<String, Object> memberLoginId(String loginId) {
        Map<String, Object> map = memberMapper.memberLoginId(loginId);        
        return map;
    }

    @Override
    public Map<String, Object> memberNickname(String nickname) {
        Map<String, Object> map = memberMapper.memberNickname(nickname);        
        return map;
    }

    @Override
    public void memberSave(MemberInsertDto memberInsertDto) {
        memberMapper.memberSave(Member.ofUser(memberInsertDto));  
    }

    @Override
    public void authoritySave(Authority authority) {
        memberMapper.authoritySave(authority);        
    }

    @Override
    public Map<String, Object> memberUsername(String username) {
        Map<String, Object> memberMap = memberMapper.memberUsername(username);        
        return memberMap;
    }

    @Override
    public Map<String, Object> getAuthority(String loginId) {
        Map<String, Object> memberMap = memberMapper.getAuthority(loginId);        
        return memberMap;
    }



}
