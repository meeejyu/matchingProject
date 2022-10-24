package com.mypetlikeit.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.mypetlikeit.comm.validation.ValidationGroups;
import com.mypetlikeit.comm.validation.ValidationGroups.NotBlankGroup;
import com.mypetlikeit.comm.validation.ValidationGroups.PatternCheckGroup;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class MemberInsertDto {
    
    private long id;

    @NotBlank(message = "아이디를 입력하지 않았습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "아이디는 5~20자이고, 영문 소문자와 숫자만 사용가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하지 않았습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 모두 사용한 8~16자만 가능합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotBlank(message = "닉네임은 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "닉네임 형식에 맞지 않습니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String nickname;

    @NotBlank(message = "이메일은 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Email(message = "이메일 형식에 맞지 않습니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String email;

    // @NotBlank
    // private String profile;

    // @NotBlank
    // private String address;

    @NotBlank(message = "펫 유무를는 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String petYN;

    // @NotBlank
    private String petName;

    // @NotBlank
    private String petCategory;

    @NotBlank(message = "원하는 펫 종류를 골라주세요. 필수값입니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String wantPet;

    public MemberInsertDto( /* long id, */
            @NotBlank(message = "아이디를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "아이디는 5~20자이고, 영문 소문자와 숫자만 사용가능합니다.", groups = PatternCheckGroup.class) String loginId,
            @NotBlank(message = "비밀번호를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 모두 사용한 8~16자만 가능합니다.", groups = PatternCheckGroup.class) String password,
            @NotBlank(message = "닉네임은 필수값입니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "닉네임 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String nickname,
            @NotBlank(message = "이메일은 필수값입니다.", groups = NotBlankGroup.class) @Email(message = "이메일 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String email,
            @NotBlank(message = "펫 유무를는 필수값입니다.") String petYN, String petName, String petCategory,
            @NotBlank(message = "원하는 펫 종류를 골라주세요. 필수값입니다.") String wantPet) {
        // this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.petYN = petYN;
        this.petName = petName;
        this.petCategory = petCategory;
        this.wantPet = wantPet;
    }

    // public MemberInsertDto(@NotBlank String loginId, @NotBlank String password, @NotBlank String nickname,
    //         @NotBlank String email, String petYN, String petName, String petCategory, @NotBlank String wantPet) {
    //     this.loginId = loginId;
    //     this.password = password;
    //     this.nickname = nickname;
    //     this.email = email;
    //     this.petYN = petYN;
    //     this.petName = petName;
    //     this.petCategory = petCategory;
    //     this.wantPet = wantPet;
    // }
}
