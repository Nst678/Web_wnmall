package com.woniu.mybatis.entity;

import java.math.BigDecimal;

/**
 * 购物车实体类
 */

public class ShopCart {
    private int id;
    private int userId;
    private Goods goods;
    private Integer number;
    private String addTime;
    private BigDecimal price;

    @Override
    public String toString() {
        return "ShopCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", goods=" + goods +
                ", number=" + number +
                ", addTime='" + addTime + '\'' +
                ", price=" + price +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

}
