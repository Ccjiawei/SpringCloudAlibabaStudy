package com.chenjw.exception;

public class CustomerSocketTimeoutException extends RuntimeException {

    private String errMsg;

    public CustomerSocketTimeoutException(String message, String errMsg) {
        super(message);
        this.errMsg = errMsg;
    }

    public CustomerSocketTimeoutException(String message, Throwable cause, String errMsg) {
        super(message, cause);
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }

}
