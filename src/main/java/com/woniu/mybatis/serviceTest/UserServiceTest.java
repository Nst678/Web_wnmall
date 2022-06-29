package com.woniu.mybatis.serviceTest;

import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.entity.User;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.ProxyFactory;
import com.woniu.mybatis.service.UserService;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.PublicKey;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class UserServiceTest {
    private UserService userService = ProxyFactory.getProxy(UserService.class);

    @Test
    /**
     *@描述 多条件分页查询用户信息
     *@参数 []
     *@返回值 void
     */
    public void getUserByCondition(){
        User user = new User();
        user.setGender("女");
        try {
            PageBean<User> userPageBean = userService.getUserByCondition(user, 2);
            userPageBean.getData().forEach(System.out::println);
            System.out.println(userPageBean.getCurrPageSize());
            System.out.println(userPageBean.getCurrPage());
            System.out.println(userPageBean.getTotalPages());
            System.out.println(userPageBean.getTotalNums());
            System.out.println(userPageBean.getPageSize());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 用户注册
     *@参数 []
     *@返回值 void
     */
    public void userRegister(){
        User user = new User();
        user.setAccount("十年磨一剑");
        user.setPassword("77894asd");
        user.setPhone("33654847891");
        user.setEmail("13115@qq.com");
        user.setGender("男");
        try {
            userService.UserRegister(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    @Test
    /**
     *@描述 用户登录
     *@参数 []
     *@返回值 void
     */
    public void userLogin(){
        try {
            userService.userLogin("10086","1234568745");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     *@描述 个人中心查看个人信息
     *@参数 []
     *@返回值 void
     */
    public void userInfo(){
        try {
            User user = userService.userInfo(6);
            System.out.println(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    @Test
    /**
     *@描述 修改个人信息
     *@参数 []
     *@返回值 void
     */
    public void updateUserInfo(){
        User user = new User();
        user.setId(5);
        user.setPassword("66666666666");
        user.setPhone("15851987777");
        user.setEmail("5489744568@qq.com");
        try {
            userService.updateUserInfo(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


}
