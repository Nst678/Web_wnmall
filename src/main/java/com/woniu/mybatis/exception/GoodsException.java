package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class GoodsException extends ServiceException{
    public GoodsException() {
    }

    public GoodsException(String msg) {
        super(msg);
    }

    public GoodsException(Throwable cause) {
        super(cause);
    }

    public GoodsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
