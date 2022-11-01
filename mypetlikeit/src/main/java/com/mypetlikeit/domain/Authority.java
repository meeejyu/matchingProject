package com.mypetlikeit.domain;

import org.springframework.security.core.GrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Authority implements GrantedAuthority{
    
    private Long id;

    private Long memberId;

    private String role;

    public static Authority ofUser(long memberId) {
        return Authority.builder()
                    .role("ROLE_USER")
                    .memberId(memberId)
                    .build();
    }

    public static Authority ofAdmin(long memberId) {
        return Authority.builder()
                    .role("ROLE_ADMIN")
                    .memberId(memberId)
                    .build();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
