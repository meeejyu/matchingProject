package com.mypetlikeit.domain.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
// @RedisHash("refreshToken")
@AllArgsConstructor
@Builder
public class RefreshToken {
    
    private String id;

    private String refreshToken;

    // @TimeToLive
    private Long expiration;

    public static RefreshToken createRefreshToken(String username, String refreshToken, Long remainingMilliSeconds) {
        return RefreshToken.builder()
                .id(username)
                .refreshToken(refreshToken)
                .expiration(remainingMilliSeconds / 1000)
                .build();
    }
    
}
