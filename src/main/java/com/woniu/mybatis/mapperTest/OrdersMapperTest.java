package com.woniu.mybatis.mapperTest;

import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Orders;
import com.woniu.mybatis.entity.User;
import com.woniu.mybatis.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OrdersMapperTest {
    private SqlSession session;
    private OrdersMapper ordersMapper;


    @Test
    /**
     *@描述 增加订单信息
     *@参数 []
     *@返回值 void
     */
    public void testAdd(){
        User user = new User();
        user.setId(2);
        Orders orders = new Orders();
        orders.setNo("5");
        orders.setUser(user);
        orders.setTotalMoney(new BigDecimal("600"));
        orders.setPeople("王德发");
        orders.setAddress("翻斗花园112号");
        orders.setPhone("11122233344");
        orders.setStatus("1");
        ordersMapper.add(orders);
        System.out.println(orders.getId());
    }
    @Test
    /**
     *@描述 根据ID修改订单信息
     *@参数 []
     *@返回值 void
     */
    public void testUpdate(){
        Orders o= ordersMapper.getById(2);
        o.setPhone("10086111");
        ordersMapper.update(o);
    }

    @Test
    /**
     *@描述 根据ID查询订单信息带出明细和用户账号
     *@参数 []
     *@返回值 void
     */
    public void testGetById(){
        Orders o = ordersMapper.getById(2);
        System.out.println(o.getAddress());
        System.out.println(o.getOrdersItems());
        System.out.println(o.getUser().getAccount());
//        o.getOrdersItems().forEach(System.out::println);
    }

    @Test
    /**
     *@描述 根据ID数组修改状态
     *@参数 []
     *@返回值 void
     */
    public void testUpdateByIds(){
        ordersMapper.updateByIds("n",Arrays.asList(2,3));
    }

    @Test
    /**
     *@描述 多条件查询
     *@参数 []
     *@返回值 void
     */
    public void testGetByCondition(){
        PageHelper.startPage(1,2);
        Orders orders = new Orders();
        orders.setStatus("n");
        List<Orders> list = ordersMapper.getByCondition(orders);
        list.forEach(System.out::println);
    }

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        ordersMapper = session.getMapper(OrdersMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }
}
