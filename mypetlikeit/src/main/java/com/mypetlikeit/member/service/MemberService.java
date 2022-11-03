package com.mypetlikeit.member.service;

import java.util.List;

import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;

public interface MemberService {
    
    public List<Member> getMemberList();

    // void memberSave(Member member);

    void memberSave(MemberInsertDto memberInsertDto);

    void authoritySave(Authority authority);

    List<Member> memberLoginId(String id);

    List<Member> memberNickname(String nickname);

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