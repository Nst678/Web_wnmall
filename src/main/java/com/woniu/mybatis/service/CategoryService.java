package com.woniu.mybatis.service;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.exception.CategoryExistException;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.mapper.CategoryMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class CategoryService {
    /**
     * 增加类别，名称不能重复
     * @param category
     */
    public void addCategory(Category category) {
        CategoryMapper c = MybatisUtils.getMapper(CategoryMapper.class);
        if (c.getByName(category.getName()) != 0) {
            throw new CategoryExistException("类名已存在");
        }
        category.setDeleted("n");
        Integer sort = c.getMaxSort();
        category.setSort(sort == null ? 1 : sort + 1);//查询数据库获取序号
        c.add(category);
    }

    /**
     * 修改，名称不能重复，只能修改名称，序号，导航，删除标识
     * @param category
     */
    public void updateCategory(Category category) {
        CategoryMapper c = MybatisUtils.getMapper(CategoryMapper.class);
        int num = c.getByName(category.getName());
        if (num != 0) {
            Category cate = new Category();
            cate.setName(category.getName());
            List<Category> list = c.getByCondition(cate);
            int id=list.get(0).getId();
            if(category.getId()!=id){
                throw new CategoryExistException("类型名称重复");
            }
        }
        c.update(category);

    }
    /**
     *@描述 查询所有类型信息
     *@参数
     *@返回值
     */
    public List<Category> selectCategory(){
        CategoryMapper c = MybatisUtils.getMapper(CategoryMapper.class);
        return c.getAll();
    }



}
