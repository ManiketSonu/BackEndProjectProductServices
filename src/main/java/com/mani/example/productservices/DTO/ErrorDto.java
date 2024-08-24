package com.mani.example.productservices.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String message;
    private String code;
//    public ErrorDto(String message, String code) {
//        this.message = message;
//        this.code = code;
//    }

    public ErrorDto() {

    }
}
