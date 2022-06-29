package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class AdministratorException  extends ServiceException{
    public AdministratorException() {
    }

    public AdministratorException(String msg) {
        super(msg);
    }

    public AdministratorException(Throwable cause) {
        super(cause);
    }

    public AdministratorException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
