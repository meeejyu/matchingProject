package com.mypetlikeit.comm.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

/*
 * 발생한 예외에서 필요한 정보들 중 예외 코드, 예외 메시지, 응답 Status, 예외 내용들을 Wrapping 하는 역할
 */
@Getter
public class ErrorResponse {
 
    private String message;
    private String code;
    private int status;
    private List<FieldError> errors = new ArrayList<>();
 
    @Builder
    public ErrorResponse(String message, String code, int status, List<FieldError> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.errors = initErrors(errors);
    }
 
    private List<FieldError> initErrors(List<FieldError> errors) {
        return (errors == null) ? new ArrayList<>() : errors;
    }
 
    @Getter
    public static class FieldError {
        private String field;
        private String value;
        private String reason;
 
        @Builder
        public FieldError(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }
    }
}
