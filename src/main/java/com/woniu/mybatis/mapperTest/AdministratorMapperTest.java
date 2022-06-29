package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Administrator;
import com.woniu.mybatis.mapper.AdministratorMapper;
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

public class AdministratorMapperTest {
    private SqlSession session;
    private AdministratorMapper administratorMapper;
    @Test
    /**
     *@描述 增加管理员
     *@参数 []
     *@返回值 void
     */
    public void add(){
        Administrator administrator=new Administrator();
        administrator.setAccount("root");
        administrator.setPassword("123456");
        administrator.setLastLoginTime("2020-06-19");
        administrator.setLastLoginIp("192.168.12.205");
        administrator.setStatus("1");
        administratorMapper.add(administrator);
    }
    @Test
    public void delete(){
        administratorMapper.delete(1);
    }
    @Test
    /**
     *@描述 修改管理员信息
     *@参数 []
     *@返回值 void
     */
    public void update(){
        Administrator a =new Administrator();
        a.setId(2);
        a.setStatus("2");
        a.setAccount("manager");
        a.setPassword("666666");
        administratorMapper.update(a);
    }
    @Test
    /**
     *@描述 通过ID查管理员信息
     *@参数 []
     *@返回值 void
     */
    public void getById(){
        Administrator a=administratorMapper.getById(2);
        System.out.println(a);
    }
    @Test
    /**
     *@描述 根据账户查管理员数量
     *@参数 []
     *@返回值 void
     */
    public void getAccount(){
        System.out.println(administratorMapper.getByAccount("manager"));
    }

    @Test
    /**
     *@描述 根据账号密码查管理员
     *@参数 []
     *@返回值 void
     */
    public void getByAccountAndPassword(){
        System.out.println(administratorMapper.getByAccountAndPassword("root","123456"));
    }

    @Test
    /**
     *@描述 获取所有管理员信息
     *@参数 []
     *@返回值 void
     */
    public void getAll(){
        List<Administrator> all = administratorMapper.getAll();
        all.forEach(System.out::println);
    }

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        administratorMapper = session.getMapper(AdministratorMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() {
        session.commit();//一定要手动提交
    }
}
