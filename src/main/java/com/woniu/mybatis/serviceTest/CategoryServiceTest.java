package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.CategoryService;
import com.woniu.mybatis.service.ProxyFactory;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;

import java.rmi.server.ServerCloneException;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class CategoryServiceTest {
    private CategoryService categoryService = ProxyFactory.getProxy(CategoryService.class);

    @Test
    /**
     *@描述 测试业务逻辑层添加类型方法
     *@参数 []
     *@返回值 void
     */
    public void addCategory() {
        Category category = new Category();
        category.setName("仙侠");
        try {
            categoryService.addCategory(category);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 修改类型信息
     *@参数 []
     *@返回值 void
     */
    public void updateCategory(){
        Category category = new Category();
        category.setId(7);
        category.setName("搞笑");
        category.setNavigation("y");
        category.setDeleted("n");
        category.setSort(11);
        try {
            categoryService.updateCategory(category);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    @Test
    /**
     *@描述 获取所有类型信息
     *@参数 []
     *@返回值 void
     */
    public void getAllCategory(){
        List<Category> cs = null;
        try {
            cs = categoryService.selectCategory();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        cs.forEach(System.out::println);
    }


}
