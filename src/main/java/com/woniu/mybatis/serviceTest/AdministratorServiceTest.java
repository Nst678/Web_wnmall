package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.Administrator;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.AdministratorService;
import com.woniu.mybatis.service.ProxyFactory;
import org.junit.Test;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class AdministratorServiceTest {
    private AdministratorService admin=ProxyFactory.getProxy(AdministratorService.class);

    @Test
    /**
     *@描述 管理员登录
     *@参数 []
     *@返回值 void
     */
    public void loginAdmin(){
        try {
            admin.loginAdmin("123456","123456");
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
    @Test
    /**
     *@描述增加管理员
     *@参数
     *@返回值
     */
    public void addAdmin(){
        Administrator newAdmin = new Administrator();
        newAdmin.setAccount("asdasd");
        newAdmin.setPassword("777777");
        newAdmin.setLastLoginTime("now()");
        newAdmin.setLastLoginIp("192.168.12.205");
        newAdmin.setStatus("y");
        try {
            admin.addAdmin(newAdmin);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }

    @Test
    /**
     *@描述 修改管理员密码
     *@参数 []
     *@返回值 void
     */
    public void updateAdminPS(){
        Administrator newAdmin = new Administrator();
        newAdmin.setId(4);
        newAdmin.setAccount("999999");
        newAdmin.setPassword("777777");
        newAdmin.setLastLoginTime("2022-06-25 11:22:30");
        newAdmin.setLastLoginIp("192.168.12.205");
        newAdmin.setStatus("y");
        try {
            admin.updateAdminPS(newAdmin);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 逻辑删除管理员
     *@参数 []
     *@返回值 void
     */
    public void deleteAdmin(){
        Administrator newAdmin = new Administrator();
        newAdmin.setId(4);
        newAdmin.setAccount("999999");
        newAdmin.setPassword("777777");
        newAdmin.setLastLoginTime("2022-06-25 11:22:30");
        newAdmin.setLastLoginIp("192.168.12.205");
        newAdmin.setStatus("n");
        try {
            admin.ChangeAdminStatus(newAdmin);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 查询所有管理员信息
     *@参数 []
     *@返回值 void
     */
    public void getAllAdmin(){
        List<Administrator> allAdmin = null;
        try {
            allAdmin = admin.getAllAdmin();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        allAdmin.forEach(System.out::println);
    }
}
