package com.chenjw.enums;

public enum ResultEnum {

    SUCCESS(200, "成功"),
    FAILURE_401(401, "参数错误"),
    FAILURE_500(500, "服务器错误");


    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
