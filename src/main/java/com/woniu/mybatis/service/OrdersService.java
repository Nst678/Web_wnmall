package com.woniu.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.Orders;
import com.woniu.mybatis.entity.OrdersItem;
import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.mapper.GoodsMapper;
import com.woniu.mybatis.mapper.OrdersItemMapper;
import com.woniu.mybatis.mapper.OrdersMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class OrdersService {
    /**
     * 多条件分页查询订单
     *
     * @param orders
     * @return
     */
    public PageBean<Orders> getOrdersByCondition(Orders orders, int pageNum) {
        OrdersMapper ordersMapper = MybatisUtils.getMapper(OrdersMapper.class);
        Page page = PageHelper.startPage(pageNum, MybatisUtils.PAGESIZE);
        List<Orders> ordersList = ordersMapper.getByCondition(orders);
        return (PageBean<Orders>)MybatisUtils.getPageBean(orders.getClass(),page,ordersList,pageNum);
    }

    /**
     * 查看订单详细信息
     *
     * @param ordersId
     * @return
     */
    public Orders getOrdersItemById(int ordersId) {
        OrdersMapper ordersMapper = MybatisUtils.getMapper(OrdersMapper.class);
        return ordersMapper.getById(ordersId);
    }

    /**
     * 增加订单信息，同时增加对应订单明细，修改商品库存
     * @param orders
     * @param ids
     * @param nums
     */
    public void addOrders(Orders orders, List<Integer> ids, List<Integer> nums) {
        //传进来的orders内缺少no,time,totalPrice,status属性
        //ids为此次订单商品ID集合
        //nums是对应商品数量的集合
        OrdersMapper ordersMapper = MybatisUtils.getMapper(OrdersMapper.class);
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        OrdersItemMapper ordersItemMapper = MybatisUtils.getMapper(OrdersItemMapper.class);
        String no = "WN" + MybatisUtils.nowTime() + (int) ((Math.random() * 8999) + 1000);//随机编码
        BigDecimal totalMoney = new BigDecimal("0");
        for (int i = 0; i <ids.size() ; i++) {
            //通过ID获取商品价格,再把商品价格乘以对应数量加到totalMoney上
            BigDecimal salesPrice = goodsMapper.getById(ids.get(i)).getSalesPrice();
            totalMoney=totalMoney.add(salesPrice.multiply(new BigDecimal(nums.get(i))));
        }
        orders.setNo(no);
        orders.setStatus("y");
        orders.setTotalMoney(totalMoney);
        ordersMapper.add(orders);
        for (int i = 0; i <ids.size() ; i++) {
            //通过遍历商品ID集合，增加订单明细
            OrdersItem ordersItem = new OrdersItem();
            ordersItem.setOrdersId(orders.getId());
            Goods goods = new Goods();
            goods.setId(ids.get(i));
            ordersItem.setGoods(goods);
            ordersItem.setNum(nums.get(i));
            BigDecimal salesPrice = goodsMapper.getById(ids.get(i)).getSalesPrice();
            ordersItem.setPrice(salesPrice.multiply(new BigDecimal(nums.get(i))));
            ordersItemMapper.add(ordersItem);
        }
        for (int i = 0; i <ids.size() ; i++) {
            //通过商品ID得到该商品的信息拿到库存再减去用户购买数量,修改库存
            Goods goods = new Goods();
            goods.setId(ids.get(i));
            int stock = goodsMapper.getById(ids.get(i)).getStock()-nums.get(i);
            goods.setStock(stock);
            goodsMapper.update(goods);
        }

    }



}
