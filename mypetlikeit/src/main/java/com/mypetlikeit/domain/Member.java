package com.mypetlikeit.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {
    
    private long id;

    // NotBlank로 변경
    @NotBlank(message = "id_chk1")
    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "id_chk2")
    private String loginId;

    @NotBlank(message = "pw_chk1")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,16}$", message = "pw_chk2")
    private String password;

    private String username;

    @NotBlank(message = "pw_more_chk1")
    private String more_password;

    // 2~16자 제한 정규식 추가
    // ^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$
    @NotBlank(message = "nick_chk1")
    @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{2,16}$", message = "nick_chk2")
    private String nickname;

    @NotBlank(message = "email_chk1")
    @Email(message = "email_chk2")
    private String email;

    @NotBlank(message = "petYN_chk1")
    private String petYN;

    // @NotEmpty
    private String petName;

    // @NotEmpty
    private String petCategory;

    @NotBlank(message = "want_pet_chk1")
    private String wantPet;

    // jwt 적용을 위한 권한 설정
    @Builder.Default
    private Set<Authority> authorities = new HashSet<>();

    public static Member ofUser(MemberInsertDto memberInsertDto) {
        Member member = Member.builder()
                        .loginId(memberInsertDto.getLoginId())
                        .password(memberInsertDto.getPassword())
                        .username(UUID.randomUUID().toString())
                        .nickname(memberInsertDto.getNickname())
                        .email(memberInsertDto.getEmail())
                        .petYN(memberInsertDto.getPetYN())
                        .petName(memberInsertDto.getPetName())
                        .petCategory(memberInsertDto.getPetCategory())
                        .wantPet(memberInsertDto.getWantPet())
                        .build();
        // member.addAuthority(Authority.ofUser(member.getLoginId()));
        return member;
    }

    // public static Member ofAdmin(MemberInsertDto memberInsertDto) {
    //     Member member = Member.builder()
    //                     .loginId(memberInsertDto.getLoginId())
    //                     .email(memberInsertDto.getEmail())
    //                     .password(memberInsertDto.getPassword())
    //                     .nickname(memberInsertDto.getNickname())
    //                     .email(memberInsertDto.getEmail())
    //                     .petYN(memberInsertDto.getPetYN())
    //                     .petName(memberInsertDto.getPetName())
    //                     .petCategory(memberInsertDto.getPetCategory())
    //                     .build();
    //     member.addAuthority(Authority.ofAdmin(member.getLoginId()));
    //     return member;
    // }

    // public Member(
    //         @NotBlank(message = "id_chk1") @Pattern(regexp = "^([a-z]+[0-9]*)$", message = "id_chk2") String loginId,
    //         @NotBlank(message = "pw_chk1") @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,16}$", message = "pw_chk2") String password,
    //         @NotBlank(message = "pw_more_chk1") String more_password,
    //         @NotBlank(message = "nick_chk1") @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{2,16}$", message = "nick_chk2") String nickname,
    //         @NotBlank(message = "email_chk1") @Email(message = "email_chk2") String email,
    //         @NotBlank(message = "petYN_chk1") String petYN, String petName, String petCategory,
    //         @NotBlank(message = "want_pet_chk1") String wantPet) {
    //     this.loginId = loginId;
    //     this.password = password;
    //     this.more_password = more_password;
    //     this.nickname = nickname;
    //     this.email = email;
    //     this.petYN = petYN;
    //     this.petName = petName;
    //     this.petCategory = petCategory;
    //     this.wantPet = wantPet;
    // }

    private void addAuthority(Authority authority) {
        authorities.add(authority);
    }

    public List<String> getRoles() {
        return authorities.stream()
                .map(Authority::getRole)
                // .collect(toList());
                .collect(Collectors.toList());
    }
}
