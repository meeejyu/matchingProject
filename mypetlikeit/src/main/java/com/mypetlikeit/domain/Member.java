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

    public Member(@NotEmpty String loginId, @NotEmpty String password) {
        this.loginId = loginId;
        this.password = password;
    }

}
