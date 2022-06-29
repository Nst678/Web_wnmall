package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class UserException extends ServiceException{
    public UserException() {
    }

    public UserException(String msg) {
        super(msg);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
