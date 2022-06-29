package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户的Mapper接口
 *
 * @author
 *
 */

public interface UserMapper {
    /**
     * 增加用户
     * @param user
     */
    void add(User user);


    /**
     * 修改用户信息
     * @param
     */
    void update(User user);

    /**
     * 根据ID查找一条用户信息
     * @param numuber
     * @return
     */
    User getById(int numuber);

    /**
     * 多条件查找用户
     * @return
     */
    List<User> getByCondition(User user);

    /**
     * 根据账号/邮箱/手机号查找用户数量
     * @param
     * @return
     */
    int getByAEP(@Param("column") String column,@Param("value") String value);

    /**
     * 根据账号密码查用户
     * @param account
     * @param password
     * @return
     */
    User getByAccAndPas(@Param("account") String account,@Param("password") String password);

}
