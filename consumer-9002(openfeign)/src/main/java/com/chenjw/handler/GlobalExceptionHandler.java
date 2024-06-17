package com.chenjw.handler;

import com.chenjw.common.Result;
import com.chenjw.exception.CustomerSocketTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = CustomerSocketTimeoutException.class)
    public Result handlerException(CustomerSocketTimeoutException socketTimeoutException){

        log.error("CustomerSocketTimeoutException, errInfo:{}", socketTimeoutException.getErrMsg(), socketTimeoutException);

        return Result.error(socketTimeoutException.getErrMsg());

    }

    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception exception){

        log.error("Exception, errInfo:{}", exception.getMessage(), exception);

        return Result.error(exception.getMessage());

    }
}
