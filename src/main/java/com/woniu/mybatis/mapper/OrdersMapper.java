package com.woniu.mybatis.mapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.woniu.mybatis.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    /**
     * 增加订单
     * @param orders
     */
    void add(Orders orders);
    /**
     * 删除订单
     * @param number
     */
    void delete(int number);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据ID查找一条订单信息
     * @param numuber
     * @return
     */
    Orders getById(int numuber);

    /**
     * 根据条件查询
     * @param orders
     * @return
     */
    List<Orders> getByCondition(Orders orders);

    /**
     * 根据一组ID批量修改数据
     * @param
     */
    void updateByIds(@Param("status") String status, @Param("ids") List<Integer> ids);

}

