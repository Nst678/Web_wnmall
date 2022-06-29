package com.woniu.mybatis.service;

import com.woniu.mybatis.exception.ServiceException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class ProxyFactory {
    public static <T> T getProxy(Class<T> c) {
        Enhancer e = new Enhancer();
        e.setSuperclass(c);
        e.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                Object result = null;
                SqlSession session = MybatisUtils.getSession();
                try {
                    result = proxy.invokeSuper(obj, args); // 调用被代理目标的方法
                    session.commit();
                } catch (PersistenceException e) { // MyBatis出错
                    e.printStackTrace();
                    session.rollback();
                    throw new ServiceException("数据操作失败", e); // 异常链
                } finally {
                        MybatisUtils.close(session);
                }
                return result;
            }
        });
        return (T) e.create();
    }
}
