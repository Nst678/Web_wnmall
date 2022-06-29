package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.mapper.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CategoryMapperTest {
    private CategoryMapper categoryMapper;
    private SqlSession session;


    @Test
    /**
     *@描述 增加一个类型
     *@参数 []
     *@返回值
     */
    public void add() {
        Category category = new Category();
        category.setName("科技");
        category.setNavigation("y");
        category.setSort(5);
        category.setDeleted("n");
        categoryMapper.add(category);
    }


    @Test
    /**
     *@描述 根据id动态修改一个类型
     *@参数 []
     *@返回值 void
     */
    public void update(){
       Category c = new Category();
       c.setId(1);
       c.setName("玄幻");
       categoryMapper.update(c);
    }

    @Test
    /**
     *@描述 根据ID查询一条类型信息
     *@参数 []
     *@返回值 void
     */
    public void getById(){
        System.out.println(categoryMapper.getById(1));
    }

    @Test
    /**
     *@描述 多条件查询类型
     *@参数 []
     *@返回值 void
     */
    public void getByCondition(){
        Category category = new Category();
        category.setName("玄幻");
        List categories= categoryMapper.getByCondition(category);
        categories.forEach(System.out::println);
    }

    @Test
    /**
     *@描述 根据类型名称查找数量
     *@参数 []
     *@返回值 void
     */
    public void getByName(){
        System.out.println(categoryMapper.getByName("玄幻"));
    }

    @Test
    /**
     *@描述 找到最大的序号
     *@参数 []
     *@返回值 void
     */
    public void getMaxSort(){
        System.out.println(categoryMapper.getMaxSort());
    }

    @Test
    public void getAll(){
        List<Category> all = categoryMapper.getAll();
        all.forEach(System.out::println);
    }
    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        categoryMapper = session.getMapper(CategoryMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }


}
