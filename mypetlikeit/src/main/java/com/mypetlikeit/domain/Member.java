package com.mypetlikeit.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.mypetlikeit.comm.validation.ValidationGroups;
import com.mypetlikeit.comm.validation.ValidationGroups.NotBlankGroup;
import com.mypetlikeit.comm.validation.ValidationGroups.PatternCheckGroup;

import lombok.Getter;
import lombok.ToString;


@Getter @ToString
public class Member {
    
    private long id;

    @NotEmpty(message = "id_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "id_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String loginId;

    @NotEmpty(message = "pw_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "pw_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotEmpty(message = "pw_more_chk1", groups = ValidationGroups.NotBlankGroup.class)
    private String more_password;

    @NotEmpty(message = "nick_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "nick_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String nickname;

    @NotEmpty(message = "email_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Email(message = "email_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String email;

    // @NotEmpty
    // private String profile;

    // @NotEmpty
    // private String address;

    @NotEmpty(message = "petYN_chk1", groups = ValidationGroups.NotBlankGroup.class)
    private String petYN;

    // @NotEmpty
    private String petName;

    // @NotEmpty
    private String petCategory;

    @NotEmpty(message = "want_pet_chk1", groups = ValidationGroups.NotBlankGroup.class)
    private String wantPet;

    public Member(
            @NotEmpty(message = "id_chk1", groups = NotBlankGroup.class) @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "id_chk2", groups = PatternCheckGroup.class) String loginId,
            @NotEmpty(message = "pw_chk1", groups = NotBlankGroup.class) @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "pw_chk2", groups = PatternCheckGroup.class) String password,
            @NotEmpty(message = "pw_more_chk1", groups = NotBlankGroup.class) String more_password,
            @NotEmpty(message = "nick_chk1", groups = NotBlankGroup.class) @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "nick_chk2", groups = PatternCheckGroup.class) String nickname,
            @NotEmpty(message = "email_chk1", groups = NotBlankGroup.class) @Email(message = "email_chk2", groups = PatternCheckGroup.class) String email,
            @NotEmpty(message = "petYN_chk1", groups = NotBlankGroup.class) String petYN, String petName,
            String petCategory, @NotEmpty(message = "want_pet_chk1", groups = NotBlankGroup.class) String wantPet) {
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
