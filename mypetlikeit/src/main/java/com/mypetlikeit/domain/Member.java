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

    @NotEmpty(message = "아이디를 입력하지 않았습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "아이디는 5~20자이고, 영문 소문자와 숫자만 사용가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력하지 않았습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 모두 사용한 8~16자만 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotEmpty(message = "닉네임은 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "닉네임 형식에 맞지 않습니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String nickname;

    @NotEmpty(message = "이메일은 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Email(message = "이메일 형식에 맞지 않습니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String email;

    // @NotEmpty
    // private String profile;

    // @NotEmpty
    // private String address;

    @NotEmpty(message = "펫 유무를는 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String petYN;

    // @NotEmpty
    private String petName;

    // @NotEmpty
    private String petCategory;

    @NotEmpty(message = "원하는 펫 종류를 골라주세요. 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String wantPet;

    public Member(long id,
            @NotEmpty(message = "아이디를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "아이디는 5~20자이고, 영문 소문자와 숫자만 사용가능합니다.", groups = PatternCheckGroup.class) String loginId,
            @NotEmpty(message = "비밀번호를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 모두 사용한 8~16자만 가능합니다.", groups = PatternCheckGroup.class) String password,
            @NotEmpty(message = "닉네임은 필수값입니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "닉네임 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String nickname,
            @NotEmpty(message = "이메일은 필수값입니다.", groups = NotBlankGroup.class) @Email(message = "이메일 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String email,
            @NotEmpty(message = "펫 유무를는 필수값입니다.", groups = NotBlankGroup.class) String petYN, String petName,
            String petCategory,
            @NotEmpty(message = "원하는 펫 종류를 골라주세요. 필수값입니다.", groups = NotBlankGroup.class) String wantPet) {
        this.id = id;
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
