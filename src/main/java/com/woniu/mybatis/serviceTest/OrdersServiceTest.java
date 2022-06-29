package com.woniu.mybatis.serviceTest;

import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Orders;
import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.entity.User;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.mapper.OrdersMapper;
import com.woniu.mybatis.service.MybatisUtils;
import com.woniu.mybatis.service.OrdersService;
import com.woniu.mybatis.service.ProxyFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class OrdersServiceTest {
    private OrdersService ordersService = ProxyFactory.getProxy(OrdersService.class);

    @Test
    /**
     *@描述 多条件分页查询订单
     *@参数 []
     *@返回值 void
     */
    public void getOrdersByCondition(){
        Orders orders = new Orders();
        orders.setAddress("翻斗花园112号");
        PageBean<Orders> ordersPageBean = ordersService.getOrdersByCondition(orders, 2);
        ordersPageBean.getData().forEach(System.out::println);
        System.out.println(ordersPageBean.getCurrPageSize());
        System.out.println(ordersPageBean.getCurrPage());
        System.out.println(ordersPageBean.getTotalPages());
        System.out.println(ordersPageBean.getTotalNums());
        System.out.println(ordersPageBean.getPageSize());
    }
    @Test
    /**
     *@描述 根据订单ID查看该订单详细信息
     *@参数 []
     *@返回值 void
     */
    public void getOrdersItemById(){
        Orders orders = ordersService.getOrdersItemById(2);
        System.out.println(orders);
    }

    @Test
    /**
     *@描述 增加订单及对应订单详情并减少商品库存
     *@参数 []
     *@返回值 void
     */
    public void addOrders(){
        Orders orders = new Orders();
        User user = new User();
        user.setId(4);
        orders.setUser(user);
        orders.setAddress("四川成都");
        orders.setPeople("熊猫");
        orders.setPhone("10086110086");
        List<Integer> ids = Arrays.asList(3, 4, 5, 6);
        List<Integer> nums = Arrays.asList(2, 2, 2, 2);
        try {
            ordersService.addOrders(orders,ids,nums);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


}
