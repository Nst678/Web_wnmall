package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.User;
import com.woniu.mybatis.mapper.UserMapper;
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

public class UserMapperTest {
    private SqlSession session;
    private UserMapper userMapper;

    @Test
    /**
     *@描述 添加用户信息
     *@参数 []
     *@返回值 void
     */
    public void add() throws IOException {
        User user = new User();
        user.setAccount("100861564");
        user.setPassword("123456");
        user.setPhone("15851980897");
        user.setEmail("164412382@qq.com");
        user.setGender("女");
        user.setLoginTime("2022-06-20");
//        user.setPoints(0);
        user.setMoney(new BigDecimal("10000"));
        user.setPhoto("emoj");
        user.setStatus("1");
        userMapper.add(user);
    }



    @Test
    /**
     *@描述 修改用户信息
     *@参数 []
     *@返回值 void
     */
    public void update(){
        User u = userMapper.getById(2);
        u.setStatus("2");
        u.setGender("男");
        u.setEmail("111qq.com");
        userMapper.update(u);
    }

    @Test
    /**
     *@描述 根据ID查找用户信息
     *@参数 []
     *@返回值 void
     */
    public void getById(){
        System.out.println(userMapper.getById(2));
    }

    @Test
    /**
     *@描述 多条件查找用户信息
     *@参数 []
     *@返回值 void
     */
    public void getByCondition(){
        User user = new User();
        user.setGender("女");
        user.setStatus("1");
        List<User> users = userMapper.getByCondition(user);
        users.forEach(System.out::println);

    }

    @Test
    /**
     *@描述 通过账号/邮箱/手机号 查找用户信息
     *@参数 []
     *@返回值 void
     */
    public void getByAEP(){
        System.out.println(userMapper.getByAEP("account","10086"));
    }

    @Test
    /**
     *@描述 根据账号和密码查询用户
     *@参数 []
     *@返回值 void
     */
    public void getByAccAndPas(){
        User user = userMapper.getByAccAndPas("10086", "123");
        System.out.println(user);
    }

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }
}
