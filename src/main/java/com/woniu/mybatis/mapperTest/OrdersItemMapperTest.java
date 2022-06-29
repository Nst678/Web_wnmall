package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.OrdersItem;
import com.woniu.mybatis.mapper.OrdersItemMapper;
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
import java.util.List;

public class OrdersItemMapperTest {
    private SqlSession session;
    private OrdersItemMapper ordersItemMapper;


    @Test
    /**
     *@描述 增加订单明细
     *@参数 []
     *@返回值 void
     */
    public void testAdd(){
        Goods goods = new Goods();
        goods.setId(3);
        OrdersItem ordersItem = new OrdersItem();
        ordersItem.setOrdersId(2);
        ordersItem.setGoods(goods);
        ordersItem.setNum(15);
        ordersItem.setPrice(new BigDecimal("150"));
        ordersItemMapper.add(ordersItem);
        System.out.println(ordersItem.getId());
    }
    @Test
    /**
     *@描述 修改订单明细
     *@参数 []
     *@返回值 void
     */
    public void testUpdate(){
        OrdersItem oi = ordersItemMapper.getById(2);
        oi.setPrice(new BigDecimal("13500"));
        ordersItemMapper.update(oi);
    }

    @Test
    public void testGetById(){
        OrdersItem oi =ordersItemMapper.getById(3);
        System.out.println(oi);
    }

    @Test
    /**
     *@描述 根据订单ID查询订单明细
     *@参数 []
     *@返回值 void
     */
    public void testGetByOrdersId(){
        List<OrdersItem> oi =ordersItemMapper.getByOrdersId(2);
        System.out.println(oi);
    }

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        ordersItemMapper = session.getMapper(OrdersItemMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }
}
