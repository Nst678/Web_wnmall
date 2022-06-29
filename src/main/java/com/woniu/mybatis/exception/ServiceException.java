package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {}

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
