package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.Area;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.AreaService;
import com.woniu.mybatis.service.ProxyFactory;
import org.junit.Test;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/27
 * @描述
 */
public class AreaServiceTest {
    private AreaService areaService = ProxyFactory.getProxy(AreaService.class);

    @Test
    /**
     *@描述 通过父ID查询地址
     *@参数 []
     *@返回值 void
     */
    public void getArea(){
        try {
            List<Area> area = areaService.getArea(1);
            area.forEach(System.out::println);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
