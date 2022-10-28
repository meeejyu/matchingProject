package com.mypetlikeit.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.ToString;


@Getter @ToString
public class Member {
    
    private long id;

    // NotBlank로 변경
    @NotBlank(message = "id_chk1")
    @Pattern(regexp = "^([a-z]+[0-9]*){5,20}$", message = "id_chk2")
    private String loginId;

    @NotBlank(message = "pw_chk1")
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "pw_chk2")
    private String password;

    @NotBlank(message = "pw_more_chk1")
    private String more_password;

    // 2~16자 제한 정규식 추가
    // ^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$
    @NotBlank(message = "nick_chk1")
    @Pattern(regexp = "/^[ㄱ-ㅎa-zA-Zㅏ-ㅣ0-9가-힣]{5,20}$/", message = "nick_chk2")
    // @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]$/", message = "nick_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String nickname;

    @NotBlank(message = "email_chk1")
    @Email(message = "email_chk2")
    private String email;

    // @NotEmpty
    // private String profile;

    // @NotEmpty
    // private String address;

    @NotBlank(message = "petYN_chk1")
    private String petYN;

    // @NotEmpty
    private String petName;

    // @NotEmpty
    private String petCategory;

    @NotBlank(message = "want_pet_chk1")
    private String wantPet;

    public Member(
        @NotBlank(message = "id_chk1") @Pattern(regexp = "^([a-z]+[0-9]*)$", message = "id_chk2") String loginId,
        @NotBlank(message = "pw_chk1") @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "pw_chk2") String password,
        @NotBlank(message = "pw_more_chk1") String more_password,
        @NotBlank(message = "nick_chk1") @Pattern(regexp = "/^[a-zA-Z0-9가-힣]{5,20}$/", message = "nick_chk2") String nickname,
        @NotBlank(message = "email_chk1") @Email(message = "email_chk2") String email,
        @NotBlank(message = "petYN_chk1") String petYN, String petName, String petCategory,
        @NotBlank(message = "want_pet_chk1") String wantPet) {
    this.loginId = loginId;
    this.password = password;
    this.more_password = more_password;
    this.nickname = nickname;
    this.email = email;
    this.petYN = petYN;
    this.petName = petName;
    this.petCategory = petCategory;
    this.wantPet = wantPet;
}
}
