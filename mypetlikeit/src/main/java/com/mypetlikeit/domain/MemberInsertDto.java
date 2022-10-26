package com.mypetlikeit.domain;

import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.mypetlikeit.comm.encryption.Encryption;
import com.mypetlikeit.comm.validation.ValidationGroups;
import com.mypetlikeit.comm.validation.ValidationGroups.NotBlankGroup;
import com.mypetlikeit.comm.validation.ValidationGroups.PatternCheckGroup;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class MemberInsertDto {
    
    private long id;

    @NotEmpty(message = "id_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "id_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String loginId;

    @NotEmpty(message = "pw_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "pw_chk2", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotEmpty(message = "pw_more_chk1", groups = ValidationGroups.NotBlankGroup.class)
    private String more_password;

    // 2~16자 제한 정규식 추가
    @NotEmpty(message = "nick_chk1", groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]$/", message = "nick_chk2", groups = ValidationGroups.PatternCheckGroup.class)
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

    public MemberInsertDto(
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

    public void encryptionPass(MemberInsertDto memberInsertDto) {

        try {
            Encryption enc = new Encryption();
            String encPass = enc.encrypt(memberInsertDto.getPassword());
            this.password = encPass;
            System.out.println("암호화 : " + this.password );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // public MemberInsertDto(/* long id, */
    //         @NotEmpty(message = "아이디를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[a-zA-Z0-9]{5,20}$/", message = "아이디는 5~20자이고, 영문 소문자와 숫자만 사용가능합니다.", groups = PatternCheckGroup.class) String loginId,
    //         @NotEmpty(message = "비밀번호를 입력하지 않았습니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/", message = "비밀번호는 영문 대 소문자, 숫자, 특수문자를 모두 사용한 8~16자만 가능합니다.", groups = PatternCheckGroup.class) String password,
    //         @NotEmpty(message = "닉네임은 필수값입니다.", groups = NotBlankGroup.class) @Pattern(regexp = "/^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z|A-Z|0-9|]+$/", message = "닉네임 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String nickname,
    //         @NotEmpty(message = "이메일은 필수값입니다.", groups = NotBlankGroup.class) @Email(message = "이메일 형식에 맞지 않습니다.", groups = PatternCheckGroup.class) String email,
    //         @NotEmpty(message = "펫 유무를는 필수값입니다.", groups = NotBlankGroup.class) String petYN, String petName,
    //         String petCategory,
    //         @NotEmpty(message = "원하는 펫 종류를 골라주세요. 필수값입니다.", groups = NotBlankGroup.class) String wantPet) {
    //     // this.id = id;
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
