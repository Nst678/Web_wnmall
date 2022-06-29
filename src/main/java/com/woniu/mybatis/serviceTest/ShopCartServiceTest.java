package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.ShopCart;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.ProxyFactory;
import com.woniu.mybatis.service.ShopcartService;
import org.junit.Test;

import javax.crypto.interfaces.PBEKey;
import java.util.Arrays;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class ShopCartServiceTest {
    private ShopcartService shopcartService= ProxyFactory.getProxy(ShopcartService.class);

    @Test
    public void addShopCart(){
        try {
            shopcartService.addShopCart(4,2,2);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 修改购物车商品数量
     *@参数 []
     *@返回值 void
     */
    public void updateShopCart(){
        try {
        shopcartService.updateShopCart(2,3,5);
        }catch (ServiceException e){
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 删除购物车
     *@参数 []
     *@返回值 void
     */
    public void deleteShopCart(){
        List<Integer> list = Arrays.asList(1);
        try {
            shopcartService.deleteShopCart(list);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 通过用户ID查询他的购物车全部信息
     *@参数 []
     *@返回值 void
     */
    public void getUserShopCartInfo(){
        try {
            List<ShopCart> userShopCartInfo = shopcartService.getUserShopCartInfo(2);
            userShopCartInfo.forEach(System.out::println);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


}
