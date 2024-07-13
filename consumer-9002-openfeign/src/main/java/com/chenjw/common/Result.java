package com.chenjw.common;

import com.chenjw.enums.ResultEnum;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static Result success(){
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public static Result success(String message){
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, null);
    }

    public static <T>Result<T> success(String message, T data){
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T>Result<T> error(String message){
        return error(ResultEnum.FAILURE_500.getCode(), message);
    }

    public static <T>Result<T> error(int code, String message){
        return new Result<>(code, message, null);
    }


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setDate(T data) {
        this.data = data;
    }
}
