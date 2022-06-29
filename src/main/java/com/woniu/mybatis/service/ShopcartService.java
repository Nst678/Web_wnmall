package com.woniu.mybatis.service;

import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.ShopCart;
import com.woniu.mybatis.exception.UserException;
import com.woniu.mybatis.mapper.GoodsMapper;
import com.woniu.mybatis.mapper.ShopCartMapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class ShopcartService {
    /**
     * 添加购物车
     * @param goodsId
     * @param userId
     * @param num
     */
    public void addShopCart(int goodsId,int userId,int num){
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        ShopCartMapper shopCartMapper = MybatisUtils.getMapper(ShopCartMapper.class);
        Goods goods = goodsMapper.getById(goodsId);
        if(num> goods.getStock()){
            throw new UserException("商品库存不足");
        }
        ShopCart shopCart = new ShopCart();
        shopCart.setGoods(goods);
        shopCart.setUserId(userId);
        shopCart.setNumber(num);
        shopCart.setPrice(goods.getPrice().multiply(new BigDecimal(num)));
        shopCartMapper.add(shopCart);
    }

    /**
     * 修改购物车商品数量
     * @param
     */
    public void updateShopCart(int userId,int goodsId,int num){
        ShopCartMapper shopCartMapper = MybatisUtils.getMapper(ShopCartMapper.class);
        ShopCart shopCart = shopCartMapper.getByUidAndGid(userId, goodsId);
        shopCart.setNumber(num);
        shopCartMapper.update(shopCart);
    }

    /**
     * 删除购物车信息
     * @param ids
     */
    public void deleteShopCart(List<Integer> ids){
        ShopCartMapper shopCartMapper = MybatisUtils.getMapper(ShopCartMapper.class);
        shopCartMapper.delete(ids);
    }


    public List<ShopCart> getUserShopCartInfo(int userId){
        ShopCartMapper shopCartMapper = MybatisUtils.getMapper(ShopCartMapper.class);
        return shopCartMapper.getByUserId(userId);
    }

}
