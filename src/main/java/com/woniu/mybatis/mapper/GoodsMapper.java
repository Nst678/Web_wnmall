package com.woniu.mybatis.mapper;
import com.woniu.mybatis.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品类
 */
public interface GoodsMapper {
    /**
     * 增加商品
     * @param
     */
    void add(Goods goods);

    /**
     * 修改商品信息
     * @param
     */
    void update(Goods goods);

    /**
     * 根据ID查找一条商品信息
     * @param numuber
     * @return
     */
    Goods getById(int numuber);

    /**
     * 根据条件查询
     * @param
     * @return
     */
    List<Goods> getByCondition(Goods goods);

}
