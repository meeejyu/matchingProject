package com.mypetlikeit.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.ToString;


@Getter @ToString
public class Member {
    
    private long id;

    @NotEmpty
    @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/")
    private String loginId;

    @NotEmpty
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/")
    private String password;

    @NotEmpty
    @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/")
    private String nickname;

    @NotEmpty
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    // @NotEmpty
    // private String profile;

    // @NotEmpty
    // private String address;

    @NotEmpty
    private String petYN;

    // @NotEmpty
    private String petName;

    // @NotEmpty
    private String petCategory;

    @NotEmpty
    private String wantPet;

    public Member(@NotEmpty String loginId, @NotEmpty String password, @NotEmpty String nickname,
            @NotEmpty String email, String petYN, String petName, String petCategory, @NotEmpty String wantPet) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.petYN = petYN;
        this.petName = petName;
        this.petCategory = petCategory;
        this.wantPet = wantPet;
    }

    

}
