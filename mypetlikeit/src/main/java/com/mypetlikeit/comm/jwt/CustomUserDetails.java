package com.mypetlikeit.comm.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.mypetlikeit.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomUserDetails {
    
    private String loginId;
    private String password;

    @Builder.Default
    private List<String> roles = new ArrayList<>();
    
    // public static UserDetails of(Member member) {
    //     return CustomUserDetails.builder()
    //             .loginId(member.getLoginId())
    //             .password(member.getPassword())
    //             .roles(member.getRoles())
    //             .build();

    // }
}
