package com.happybudui.callserver.exception;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

/**
 * Exception defined for CallServer
 * @author HappyBudui
 */
public class CallServerException extends RuntimeException {

    /**
     * 错误码
     */
    private final int errorCode;

    /**
     * 返回消息
     */
    private final String message;

    public CallServerException(int errorCode) {
        super("error occurred!");
        this.errorCode = errorCode;
        this.message = "error!";
    }

    public CallServerException(String message) {
        super(message);
        this.errorCode = 200;
        this.message = message;
    }

    public CallServerException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

}