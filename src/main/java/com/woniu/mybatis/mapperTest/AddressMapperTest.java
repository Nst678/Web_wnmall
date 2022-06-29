package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Address;
import com.woniu.mybatis.mapper.AddressMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/22
 * @描述
 */
public class AddressMapperTest {
    private SqlSession session;
    private AddressMapper addressMapper;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        addressMapper = session.getMapper(AddressMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() throws Exception {
            session.commit();//一定要手动提交
    }

    @Test
    /**
     *@描述 增加地址信息
     *@参数 []
     *@返回值 void
     */
    public void add() {
        Address address = new Address();
        address.setAccept("二蛋");
        address.setPhone("1593574789");
        address.setArea("武侯");
        address.setCity("成都");
        address.setProvince("四川");
        address.setDefaulted("1");
        address.setStreet("簇锦");
        address.setUserId(2);
        addressMapper.add(address);
    }

    @Test
    /**
     *@描述 根据ID删除地址信息
     *@参数 []
     *@返回值 void
     */
    public void delete() {
        addressMapper.delete(1);
    }

    @Test
    /**
     *@描述 根据ID修改地址
     *@参数 []
     *@返回值 void
     */
    public void update() {
        Address ad = new Address();
        ad.setId(2);
        ad.setProvince("西藏");
        addressMapper.update(ad);
    }
    @Test
    /**
     *@描述 根据ID查找地址
     *@参数 []
     *@返回值 void
     */
    public void getById(){
        Address ad = addressMapper.getById(2);
        System.out.println(ad);
    }
    @Test
    /**
     *@描述 根据用户ID查询地址
     *@参数 []
     *@返回值 void
     */
    public void getByUserId() {
        List<Address> ads = addressMapper.getByUserId(2);
        ads.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void getAll(){
        System.out.println(addressMapper.getAll());
    }

    @Test
    public void getByDefaulted(){
        Address address = addressMapper.getByDefaulted("y");
        System.out.println(address);
    }
}