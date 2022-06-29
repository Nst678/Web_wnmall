package com.woniu.mybatis.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class MybatisUtils {
    public static final int PAGESIZE=2;

    private MybatisUtils() {
    }

    //控制线程中只有一个连接
    private static ThreadLocal<SqlSession> sessions = new ThreadLocal();

    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块，只加载一次mybatis-config.xml文件即可
    static {
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @描述 创建唯一连接的方法
     * 有则直接返回，没有则创建一个连接并放入sessions中
     * @参数
     * @返回值 org.apache.ibatis.session.SqlSession
     */
    public static SqlSession getSession() {
        SqlSession session = sessions.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    /**
     * 传入class，返回Mapper
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T getMapper(Class<T> c) {
        return getSession().getMapper(c);
    }

    public static void close(SqlSession session) {
        if (session != null) {
            session.close();
            sessions.remove();
        }
    }

    public static String nowTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String time = dateTimeFormatter.format(LocalDateTime.now());
        return time;
    }

    public static <T> PageBean<T> getPageBean(Class<T> c, Page page,List list,int pageNum) {
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setData(list);
        pageBean.setCurrPageSize(list.size());
        pageBean.setCurrPage(pageNum);
        pageBean.setTotalPages(page.getPages());
        pageBean.setTotalNums((int) page.getTotal());
        pageBean.setPageSize(PAGESIZE);
        return pageBean;
    }
}
