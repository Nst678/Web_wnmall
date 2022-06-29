package com.woniu.mybatis.service;

import com.woniu.mybatis.entity.Address;
import com.woniu.mybatis.exception.AddressException;
import com.woniu.mybatis.mapper.AddressMapper;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class AddressService {
    /**
     * 添加地址，不能超过五个，只能有一个默认地址
     *
     * @param address
     */
    public void addAddress(Address address) {
        AddressMapper addressMapper = MybatisUtils.getMapper(AddressMapper.class);
        int size = addressMapper.getByUserId(address.getUserId()).size();
        Address defaulted = addressMapper.getByDefaulted("y");
        if (address.getDefaulted().equals("y") && defaulted != null) {
            //如何保证只有一个默认地址
            defaulted.setDefaulted("n");
            addressMapper.update(defaulted);
        }
        if (size == 0) {
            address.setDefaulted("y");
        }else if (size >= 5) {
            throw new AddressException("收货地址最多储存5个");
        }
        addressMapper.add(address);
    }

    /**
     * 根据地址ID查询地址
     *
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId) {
        AddressMapper addressMapper = MybatisUtils.getMapper(AddressMapper.class);
        return addressMapper.getById(addressId);
    }

    /**
     * 查询指定用户的所有地址
     *
     * @param userId
     * @return
     */
    public List<Address> getUserAllAddress(int userId) {
        AddressMapper addressMapper = MybatisUtils.getMapper(AddressMapper.class);
        return addressMapper.getByUserId(userId);
    }

    /**
     * 删除指定地址，不能删除默认地址
     *
     * @param addressId
     */
    public void deleteAddress(int addressId) {
        AddressMapper addressMapper = MybatisUtils.getMapper(AddressMapper.class);
        Address address = addressMapper.getById(addressId);
        if (address.getDefaulted() .equals( "y")) {
            throw new AddressException("不能删除默认地址");
        }
        addressMapper.delete(addressId);
    }

    /**
     * 修改地址信息
     *
     * @param address
     */
    public void updateAddress(Address address) {
        AddressMapper addressMapper = MybatisUtils.getMapper(AddressMapper.class);
        Address defaulted = addressMapper.getByDefaulted("y");
        if (address.getDefaulted().equals("y") && defaulted != null && defaulted.getId() != address.getId()) {
            //如何保证只有一个默认地址
            defaulted.setDefaulted("n");
            addressMapper.update(defaulted);
        }
        addressMapper.update(address);
    }

}
