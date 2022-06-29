package com.woniu.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.mybatis.entity.Orders;
import com.woniu.mybatis.entity.PageBean;
import com.woniu.mybatis.entity.ShopCart;
import com.woniu.mybatis.entity.User;
import com.woniu.mybatis.exception.UserException;
import com.woniu.mybatis.mapper.ShopCartMapper;
import com.woniu.mybatis.mapper.UserMapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/26
 * @描述
 */
public class UserService {
    /**
     * 多条件分页查询用户信息
     * @param user
     * @return
     */
    public PageBean<User> getUserByCondition(User user,int pageNum){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        Page page = PageHelper.startPage(pageNum, MybatisUtils.PAGESIZE);
        List<User> userList = userMapper.getByCondition(user);
        return (PageBean<User>)MybatisUtils.getPageBean(user.getClass(),page,userList,pageNum);
    }

    /**
     * 用户注册
     * @param user
     */
    public void UserRegister(User user){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        if(userMapper.getByAEP("account",user.getAccount())!=0){
            throw new UserException("该账号已被注册");
        }else if(userMapper.getByAEP("email",user.getEmail())!=0){
            throw new UserException("该邮箱已被注册");
        }else if(userMapper.getByAEP("phone",user.getPhone())!=0){
            throw new UserException("该手机号已被注册");
        }
        user.setStatus("y");
        user.setMoney(new BigDecimal("0"));
        userMapper.add(user);
    }

    /**
     * 用户登录
     * @param account
     * @param password
     */
    public void userLogin(String account,String password){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        if(userMapper.getByAccAndPas(account,password)==null){
            throw new UserException("账号或密码不正确");
        }
        System.out.println("登录成功");
    }

    /**
     * 个人中心查个人信息
     * @param id
     * @return
     */
    public User userInfo(int id){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        return userMapper.getById(id);
    }

    /**
     * 修改个人信息，除账号、注册时间、积分、余额、状态，其他能修改
     * @param user
     */
    public void updateUserInfo(User user){
        UserMapper userMapper = MybatisUtils.getMapper(UserMapper.class);
        if(userMapper.getByAEP("email",user.getEmail())!=0){
            throw new UserException("该邮箱已被注册");
        }else if(userMapper.getByAEP("phone",user.getPhone())!=0){
            throw new UserException("该手机号已被注册");
        }
        userMapper.update(user);
    }

    /**
     * 通过用户ID查询他的购物车信息
     * @param userId
     * @return
     */
    public List<ShopCart> userShopCartInfo(int userId){
        ShopCartMapper shopCartMapper = MybatisUtils.getMapper(ShopCartMapper.class);
        List<ShopCart> shopCarts = shopCartMapper.getByUserId(userId);
        return shopCarts;
    }
}
