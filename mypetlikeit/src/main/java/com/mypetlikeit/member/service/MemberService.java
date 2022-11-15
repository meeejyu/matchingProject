package com.mypetlikeit.member.service;

import java.util.List;
import java.util.Map;

import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.LoginDto;
import com.mypetlikeit.domain.MemberInsertDto;

public interface MemberService {
    
    List<Map<String, Object>> getMemberList();

    void memberSave(MemberInsertDto memberInsertDto);
    
    void authoritySave(Authority authority);

    Map<String, Object> getAuthority(String id);

    Map<String, Object> memberLoginId(String loginId);

    Map<String, Object> memberNickname(String nickname);

    Map<String, Object> memberUsername(String username);   

    Map<String, Object> getLoginMember(LoginDto loginDto);

}

/*
 * 
 *  
 * 
    
    CustomUserDetailService

    @Override
    @Cacheable(value = CacheKey.USER, key = "#username", unless = "#result == null")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsernameWithAuthority(username).orElseThrow(() -> new NoSuchElementException("없는 회원입니다."));
        return CustomUserDetails.of(member);
    }

 */