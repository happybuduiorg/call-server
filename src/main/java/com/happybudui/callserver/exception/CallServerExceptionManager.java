package com.happybudui.callserver.exception;

import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

/**
 * Exception manager for Timeline
 * @author HappyBudui
 */
@RestControllerAdvice
public class CallServerExceptionManager {

    /**
     * Logger
     */
    private Logger logger = LoggerFactory.getLogger(CallServerExceptionManager.class);

    /**
     * Exception handler
     * @param e 需要处理的异常
     * @return ResponseResult
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Integer> handlerException(Exception e) {
        /*
            如果是自定义的异常，返回对应的错误信息
         */
        if (e instanceof CallServerException) {
            logger.info(e.getMessage());
            return ResultGenerator.error(((CallServerException) e).getErrorCode(), e.getMessage());
        } else {
            /*
                如果不是已知异常，返回系统异常
             */
            logger.info(e.getMessage());
            return ResultGenerator.error(200, "System Error!");
        }
    }
}