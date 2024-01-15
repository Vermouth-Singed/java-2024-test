package com.example.sample.enums;

public enum LoginEnum {
    LOGIN_INFO("loginInfo"),
    INTERCEPTOR("interceptor");

    private final String code;

    private LoginEnum(String code){
        this.code = code;
    }

    public synchronized String code(){
        return code;
    }
}
