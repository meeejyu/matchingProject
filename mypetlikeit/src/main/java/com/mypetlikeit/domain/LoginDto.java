package com.mypetlikeit.domain;

import java.security.NoSuchAlgorithmException;

import com.mypetlikeit.comm.encryption.Encryption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
// @NoArgsConstructor
@ToString
public class LoginDto {
    
    private String loginId;

    private String password;

    public void encryptionPass(LoginDto loginDto) {

        try {
            Encryption enc = new Encryption();
            String encPass = enc.encrypt(loginDto.getPassword());
            this.password = encPass;
            System.out.println("암호화 : " + this.password );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
