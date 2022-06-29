package com.woniu.mybatis.exception;

/**
 * 类别已存在异常
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class CategoryExistException extends ServiceException {

    public CategoryExistException() {
    }

    public CategoryExistException(String msg) {
        super(msg);
    }

    public CategoryExistException(Throwable cause) {
        super(cause);
    }

    public CategoryExistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
