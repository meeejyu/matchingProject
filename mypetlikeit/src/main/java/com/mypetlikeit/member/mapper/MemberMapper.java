package com.mypetlikeit.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mypetlikeit.domain.Authority;
import com.mypetlikeit.domain.Member;

@Mapper
public interface MemberMapper {
    
    List<Map<String, Object>> getMemberList();

    // Map<String, Object> getMemberList();

    void memberSave(Member member);
    
    void authoritySave(Authority authority);

    Map<String, Object> getAuthority(String loginId);

    Map<String, Object> memberLoginId(String loginId);

    Map<String, Object> memberNickname(String nickname);

    Map<String, Object> memberUsername(String username);    
    
}
