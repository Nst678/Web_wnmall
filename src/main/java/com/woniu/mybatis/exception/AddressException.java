package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class AddressException extends ServiceException{
    public AddressException() {
    }

    public AddressException(String msg) {
        super(msg);
    }

    public AddressException(Throwable cause) {
        super(cause);
    }

    public AddressException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
