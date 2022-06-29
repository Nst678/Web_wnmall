package com.woniu.mybatis.mapperTest;

import com.woniu.mybatis.entity.Area;
import com.woniu.mybatis.mapper.AreaMapper;
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
 * @创建时间 2022/6/23
 * @描述
 */
public class AreaMapperTest {
    private SqlSession session;
    private AreaMapper areaMapper;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        areaMapper = session.getMapper(AreaMapper.class);  // 获取Mapper接口的代理
    }

    @After
    public void tearDown() throws Exception {
        session.commit();//一定要手动提交
    }

    @Test
    /**
     *@描述 根据父ID找行政区
     *@参数 []
     *@返回值 void
     */
    public void getByPid() {
        List<Area> area = areaMapper.getByPid(1);
    }
}