package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.mapper.GoodsMapper;
import com.woniu.mybatis.service.GoodsService;
import com.woniu.mybatis.service.ProxyFactory;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class GoodsSreviceTest {
    private GoodsService goodsService = ProxyFactory.getProxy(GoodsService.class);

    @Test
    /**
     *@描述 增加商品
     *@参数 []
     *@返回值 void
     */
    public void addGoods(){
        Goods goods = new Goods();
        goods.setPrice(new BigDecimal("12.34"));
        goods.setIsbn("1008611");
        goods.setName("烹饪");
        Category category = new Category();
        category.setId(3);
        goods.setCategory(category);
        goods.setSalesPrice(new BigDecimal("20.15"));
        goods.setImage("www.www");
        goods.setDescription("别吃！别吃！");
        goods.setStock(50);
        goods.setSalesNum(15);
        goods.setNewest("y");
        goods.setHotest("y");
        goods.setStatus("y");
        try {
            goodsService.addGoods(goods);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 根据ID获取商品详细信息
     *@参数 []
     *@返回值 void
     */
    public void goodsInfo(){
        try {
            Goods goodsInfo = goodsService.goodsInfo(4);
            System.out.println(goodsInfo);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 修改商品信息
     *@参数 []
     *@返回值 void
     */
    public void updateGoods(){
        Goods goods = new Goods();
        goods.setId(3);
        goods.setName("启蒙文学");
        try {
            goodsService.updateGoods(goods);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 按条件查询商品
     *@参数 []
     *@返回值 void
     */
    public void getGoodsByCondition(){
        Goods goods = new Goods();
//        goods.setStock(15);
        try {
            PageBean<Goods> goodsPageBean = goodsService.getGoodsByCondition(goods, 2);
            goodsPageBean.getData().forEach(System.out::println);
            System.out.println(goodsPageBean.getCurrPageSize());
            System.out.println(goodsPageBean.getCurrPage());
            System.out.println(goodsPageBean.getTotalPages());
            System.out.println(goodsPageBean.getTotalNums());
            System.out.println(goodsPageBean.getPageSize());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
