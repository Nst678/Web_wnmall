package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartMapper {
    /**
     * 增加购物车内容
     * @param shopCart
     */
    void add(ShopCart shopCart);

    /**
     * 根据ID集合删除购物车信息
     * @param
     * @param id
     */
    void  delete(@Param("ids") List<Integer> id);

    /**
     * 修改购物车信息
     * @param shopCart
     */
    void update(ShopCart shopCart);

    /**
     * 通过用户ID查询购物车信息
     * @param userId
     * @return
     */
    List<ShopCart> getByUserId(int userId);

    /**
     * 通过用户ID和商品ID查购物车信息
     * @param userId
     * @param goodsId
     * @return
     */
    ShopCart getByUidAndGid(@Param("userId") int userId,@Param("goodsId") int goodsId);
}
