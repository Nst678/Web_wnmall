package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Category;

import java.util.List;

/**
 * 类别的Mapper接口
 *
 * @author laotan
 *
 */
public interface CategoryMapper {
    /**
     * 增加类型
     *
     * @param category
     */
    void add(Category category);

    /**
     * 修改类型信息
     * @param category
     */
    void update(Category category);

    /**
     * 根据ID查找一条类型信息
     * @param numuber
     * @return
     */
    Category getById(int numuber);

    /**
     * 根据条件查找类型信息
     * @return
     */
    List<Category> getByCondition(Category category);
    /**
     *@描述 根据类型名称查数量
     *@参数
     *@返回值
     */
    int getByName(String name);
    /**
     *@描述 找到最大的sort序号值
     *@参数
     *@返回值
     */
    Integer getMaxSort();
    /**
     *@描述 查询所有类型信息
     *@参数
     *@返回值
     */
    List<Category> getAll();


}
