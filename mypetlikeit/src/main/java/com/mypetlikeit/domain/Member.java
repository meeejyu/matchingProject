package com.mypetlikeit.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.ToString;


@Getter @ToString
public class Member {
    
    private long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String profile;

    @NotEmpty
    private String address;

    @NotEmpty
    private String petName;

    @NotEmpty
    private String petCategory;

    @NotEmpty
    private String wantPet;

    @NotEmpty
    private String wantAddress;

    public Member(@NotEmpty String loginId, @NotEmpty String password, @NotEmpty String nickname,
            @NotEmpty String email, @NotEmpty String profile, @NotEmpty String address, @NotEmpty String petName,
            @NotEmpty String petCategory, @NotEmpty String wantPet, @NotEmpty String wantAddress) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profile = profile;
        this.address = address;
        this.petName = petName;
        this.petCategory = petCategory;
        this.wantPet = wantPet;
        this.wantAddress = wantAddress;
    }

    

}
