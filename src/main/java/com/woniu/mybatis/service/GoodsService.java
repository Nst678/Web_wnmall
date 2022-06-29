package com.woniu.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Goods;
import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.exception.GoodsException;
import com.woniu.mybatis.mapper.GoodsMapper;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class GoodsService {
    /**
     * 添加商品 isbn编号不能相同
     * @param goods
     */
    public void addGoods(Goods goods){
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        int num = goodsMapper.getByCondition(goods).size();
        if(num!=0){
            throw new GoodsException("存在相同编号商品");
        }
        goodsMapper.add(goods);
    }

    /**
     * 查看商品详情
     * @param id
     * @return
     */
    public Goods goodsInfo(int id){
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        return goodsMapper.getById(id);
    }

    /**
     * 修改商品信息，除了名称和ISBN
     * @param goods
     */
    public void updateGoods(Goods goods){
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        goodsMapper.update(goods);
    }

    /**
     * 多条件分页查询商品
     * @param goods
     * @return
     */
    public PageBean<Goods> getGoodsByCondition(Goods goods,int pageNum){
        GoodsMapper goodsMapper = MybatisUtils.getMapper(GoodsMapper.class);
        Page page = PageHelper.startPage(pageNum, MybatisUtils.PAGESIZE);
        List<Goods> goodsList = goodsMapper.getByCondition(goods);
        return (PageBean<Goods>) MybatisUtils.getPageBean(goods.getClass(), page, goodsList, pageNum);
    }
}
