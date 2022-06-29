package com.woniu.mybatis.mapperTest;

import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.mapper.GoodsMapper;
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

public class GoodsMapperTest {
    private SqlSession session;
    private GoodsMapper goodsMapper;

    @Test
    /**
     *@描述 增加一个商品信息
     *@参数 []
     *@返回值 void
     */
    public void testAdd(){
        Category category = new Category();
        category.setId(1);
        category.setDeleted("y");
        Goods goods = new Goods();
        goods.setIsbn("20220621001");
        goods.setName("流星蝴蝶剑");
        goods.setCategory(category);
        goods.setPrice(new BigDecimal("35.5"));
        goods.setSalesPrice(new BigDecimal("28.5"));
        goods.setImage("www");
        goods.setDescription("好");
        goods.setStock(15);
        goods.setSalesNum(20);
        goods.setNewest("2");
        goods.setHotest("2");
        goods.setStatus("2");
        goodsMapper.add(goods);
    }

    @Test
    /**
     *@描述 根据ID修改商品信息
     *@参数 []
     *@返回值 void
     */
    public void update(){
        Goods goods = new Goods();
        goods.setName("大力");
        goods.setId(5);
        goods.setStatus("n");
        goodsMapper.update(goods);
    }

    @Test
    public void getById(){
        Goods goods = goodsMapper.getById(5);
        System.out.println(goods);
    }

    @Test
    /**
     *@描述 多条件查询商品信息
     *@参数 []
     *@返回值 void
     */
    public void testGetByCondition(){
        PageHelper.startPage(3,3);
        Goods goods = new Goods();
        goods.setStock(15);
        List list= goodsMapper.getByCondition(goods);
        list.forEach(System.out::println);
    }
    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        goodsMapper = session.getMapper(GoodsMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }
}
