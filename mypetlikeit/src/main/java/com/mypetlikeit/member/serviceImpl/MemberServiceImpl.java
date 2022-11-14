package com.mypetlikeit.member.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mypetlikeit.comm.util.JwtTokenUtil;
import com.mypetlikeit.config.jwt.JwtExpirationEnums;
import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.LoginDto;
import com.mypetlikeit.domain.Member;
import com.mypetlikeit.domain.MemberInsertDto;
import com.mypetlikeit.domain.TokenDto;
import com.mypetlikeit.domain.jwt.LogoutAccessTokenRedisRepository;
import com.mypetlikeit.domain.jwt.RefreshToken;
import com.mypetlikeit.domain.jwt.RefreshTokenRedisRepository;
import com.mypetlikeit.member.mapper.MemberMapper;
import com.mypetlikeit.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    
    private final MemberMapper memberMapper;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;
    private final LogoutAccessTokenRedisRepository logoutAccessTokenRedisRepository;
    private final JwtTokenUtil jwtTokenUtil;

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

    @Override
    public Map<String, Object> getLoginMember(LoginDto loginDto) {

        Map<String, Object> memberMap = memberMapper.getLoginMember(loginDto);
        
        // String username = (String) memberMap.get("username");
        // String accessToken = jwtTokenUtil.generateAccessToken(username);
        // RefreshToken refreshToken = saveRefreshToken(username);

        // TokenDto.of(accessToken, refreshToken.getRefreshToken());

        return memberMap;
    }

    private String resolveToken(String token) {
        return token.substring(7);
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }

    private TokenDto reissueRefreshToken(String refreshToken, String username) {
        if(lessThanReissueExpirationTimesLeft(refreshToken)) {
            String accessToken = jwtTokenUtil.generateAccessToken(username);
            return TokenDto.of(accessToken, saveRefreshToken(username).getRefreshToken());
        }
        return TokenDto.of(jwtTokenUtil.generateAccessToken(username), refreshToken);
    }

    private boolean lessThanReissueExpirationTimesLeft(String refreshToken) {
        return jwtTokenUtil.getRemainMilliSeconds(refreshToken) < JwtExpirationEnums.REISSUE_EXPIRATION_TIME.getValue();
    }

    public TokenDto reissue(String refreshToken) {
        refreshToken = resolveToken(refreshToken);
        String username = getCurrentUsername();
        RefreshToken redisRefreshToken = refreshTokenRedisRepository.findById(username).orElseThrow(NoSuchElementException::new);

        if(refreshToken.equals(redisRefreshToken.getRefreshToken())) {
            return reissueRefreshToken(refreshToken, username);
        }
        throw new IllegalArgumentException("토큰이 일치하지 않습니다.");
    }

    public TokenDto getLoginMember2(LoginDto loginDto) {

        Map<String, Object> memberMap = memberMapper.getLoginMember(loginDto);
        
        String username = (String) memberMap.get("MEMBER_USERNAME");
        String accessToken = jwtTokenUtil.generateAccessToken(username);
        RefreshToken refreshToken = saveRefreshToken(username);

        return TokenDto.of(accessToken, refreshToken.getRefreshToken());
    }

    private RefreshToken saveRefreshToken(String username) {
        return refreshTokenRedisRepository.save(RefreshToken.createRefreshToken(
            username, jwtTokenUtil.generateAccessToken(username), JwtExpirationEnums.REFRESH_TOKEN_EXPIRATION_TIME.getValue()));
    }


}
