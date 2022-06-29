package com.woniu.mybatis.exception;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class ShopCartException  extends ServiceException{
    public ShopCartException() {
    }

    public ShopCartException(String msg) {
        super(msg);
    }

    public ShopCartException(Throwable cause) {
        super(cause);
    }

    public ShopCartException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

