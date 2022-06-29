package com.woniu.mybatis.entity;

import java.math.BigDecimal;

public class OrdersItem {
    private int id;
    private int ordersId;
    private Goods goods;
    private int num;
    private BigDecimal price;

    @Override
    public String toString() {
        return "OrdersItem{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", goods=" + goods +
                ", num=" + num +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
