package com.mypetlikeit.config.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypetlikeit.domain.Member;
import com.mypetlikeit.member.serviceImpl.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberServiceImpl memberServiceImpl;
    
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        List<Member> member = memberServiceImpl.memberLoginId(loginId);

        return CustomUserDetails.of(member.get(0));
    }
    
}
