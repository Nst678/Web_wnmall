package com.woniu.mybatis.mapper;
import com.woniu.mybatis.entity.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员类
 */
public interface AdministratorMapper {
    /**
     * 增加管理员
     * @param
     */
    void add(Administrator administrator);
    /**
     * 删除管理员
     * @param number
     */
    void delete(int number);

    /**
     * 修改管理员信息
     * @param
     */
    void update(Administrator administrator);

    /**
     * 根据ID查找一条管理员信息
     * @param numuber
     * @return
     */
    Administrator getById(int numuber);

    /**
     * 根据账号查找数量
     * @return
     */
    Integer getByAccount(String account);

    /**
     * 根据账号和密码查管理员信息
     * @param account
     * @param password
     * @return
     */
    Administrator getByAccountAndPassword(@Param("account") String account,@Param("password") String password);

    /**
     * 查询所有管理员
     * @return
     */
    List<Administrator> getAll();
}
