package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/22
 * @描述
 */
public interface AddressMapper {
    /**
     * 增加地址信息
     * @param address
     */
    void add(Address address);

    /**
     * 根据ID和用户ID删除地址
     * @param id
     */
    void delete( int id);

    /**
     * 修改地址
     * @param address
     */
    void update(Address address);

    /**
     * 按照ID查询地址
     * @param id
     * @return
     */
    Address getById(int id);

    /**
     * 根据用户ID查询地址
     * @param userId
     * @return
     */
    List<Address> getByUserId(int userId);

    /**
     * 查询总数
     * @return
     */
    int getAll();

    /**
     * 查默认地址
     * @param defaulted
     * @return
     */
    Address getByDefaulted(String defaulted);
}
