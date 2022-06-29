package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.Address;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.AddressService;
import com.woniu.mybatis.service.ProxyFactory;
import org.junit.Test;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/27
 * @描述
 */
public class AdressServiceTest {
    private AddressService addressService = ProxyFactory.getProxy(AddressService.class);

    @Test
    /**
     *@描述 增加地址
     *@参数 []
     *@返回值 void
     */
    public void addAddress(){
        Address address = new Address();
        address.setUserId(2);
        address.setAccept("张三");
        address.setProvince("江苏");
        address.setCity("常州");
        address.setArea("天宁");
        address.setStreet("晋陵北路");
        address.setPhone("15991191911");
        address.setDefaulted("y");
        try {
            addressService.addAddress(address);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 根据地址ID查找地址信息
     *@参数 []
     *@返回值 void
     */
    public void getAddressById(){
        try {
            Address address = addressService.getAddressById(2);
            System.out.println(address);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 根据用户ID查找他对应的所有地址
     *@参数 []
     *@返回值 void
     */
    public void getAddressByUserId(){
        try {
            List<Address> userAllAddress = addressService.getUserAllAddress(2);
            userAllAddress.forEach(System.out::println);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteAddress(){
        try {
            addressService.deleteAddress(9);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
