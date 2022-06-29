package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.ShopCart;
import com.woniu.mybatis.mapper.ShopCartMapper;
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

/**
 * @创建人 NST
 * @创建时间 2022/6/22
 * @描述
 */
public class ShopCartMapperTest {
    private SqlSession session;
    private ShopCartMapper shopCartMapper;


    @Test
    /**
     *@描述 增加购物车数据
     *@参数 []
     *@返回值 void
     */
    public void testAdd(){
        ShopCart shopCart = new ShopCart();
        Goods goods = new Goods();
        goods.setId(3);
        shopCart.setAddTime("2022-06-22 15:21:30");
        shopCart.setNumber(2);
        shopCart.setUserId(3);
        shopCart.setPrice(new BigDecimal("123.4"));
        shopCart.setGoods(goods);
        shopCartMapper.add(shopCart);
    }

    @Test
    /**
     *@描述 修改购物车信息
     *@参数 []
     *@返回值 void
     */
    public void update(){
        ShopCart shopCart = new ShopCart();
        shopCart.setId(2);
        shopCart.setPrice(new BigDecimal("250"));
        shopCart.setNumber(25);
        shopCartMapper.update(shopCart);
    }

    @Test
    /**
     *@描述 根据用户ID和ID数组删除购物车信息
     *@参数 []
     *@返回值 void
     */
    public void delete(){
        shopCartMapper.delete(Arrays.asList(2,3));
    }

    @Test
    /**
     *@描述 根据用户Id查询购物车信息
     *@参数 []
     *@返回值 void
     */
    public void testGetByUserId(){
        List<ShopCart> shopCarts = shopCartMapper.getByUserId(2);
        shopCarts.forEach(e->{
            System.out.println(e);
        });

    }

    @Test
    /**
     *@描述 通过用户ID和商品ID查购物车中商品数量
     *@参数 []
     *@返回值 void
     */
    public void getByUidAndGid(){
        ShopCart shopCart = shopCartMapper.getByUidAndGid(2, 3);
        System.out.println(shopCart.getNumber());
    }

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        shopCartMapper = session.getMapper(ShopCartMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }

}
