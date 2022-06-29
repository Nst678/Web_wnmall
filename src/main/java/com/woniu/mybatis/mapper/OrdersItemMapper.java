package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Orders;
import com.woniu.mybatis.entity.OrdersItem;

import java.util.List;

public interface OrdersItemMapper {
    /**
     * 增加订单明细
     * @param ordersItem
     */
    void add(OrdersItem ordersItem);
    /**
     * 删除订单明细
     * @param number
     */
    void delete(int number);

    /**
     * 修改订单明细信息
     * @param ordersItem
     */
    void update(OrdersItem ordersItem);

    /**
     * 根据ID查找一条订单明细
     * @param numuber
     * @return
     */
    OrdersItem getById(int numuber);

    /**
     * 查找所有商品信息
     * @return
     */
    List<OrdersItem> getAll();

    /**
     * 根据OrdersId查找订单明细
     * @return
     */
    List<OrdersItem> getByOrdersId(int number);

}

