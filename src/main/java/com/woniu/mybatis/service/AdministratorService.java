package com.woniu.mybatis.service;

import com.woniu.mybatis.entity.Administrator;
import com.woniu.mybatis.exception.AdministratorException;
import com.woniu.mybatis.mapper.AdministratorMapper;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/25
 * @描述
 */
public class AdministratorService {
    /**
     * 管理员登录
     *
     * @param account
     * @param password
     */
    public void loginAdmin(String account, String password) {
        AdministratorMapper admin = MybatisUtils.getMapper(AdministratorMapper.class);
        Administrator isExist = admin.getByAccountAndPassword(account, password);
        if (isExist == null) {
            throw new AdministratorException("账号或密码不正确");
        }
    }

    /**
     * 增加管理员，账号不能重复
     *
     * @param administrator
     */
    public void addAdmin(Administrator administrator) {
        AdministratorMapper admin = MybatisUtils.getMapper(AdministratorMapper.class);
        int num = admin.getByAccount(administrator.getAccount());
        if (num != 0) {
            throw new AdministratorException("该账号已存在");
        }
        admin.add(administrator);
    }

    /**
     * 修改管理员密码和状态
     *
     * @param administrator
     */
    public void updateAdminPS(Administrator administrator) {
        AdministratorMapper admin = MybatisUtils.getMapper(AdministratorMapper.class);
        String password = admin.getById(administrator.getId()).getPassword();
        System.out.println(password);
        System.out.println(administrator.getPassword());
        if (password.equals(administrator.getPassword())){
            throw new AdministratorException("密码不能与原密码相同");
        }
        admin.update(administrator);
    }

    /**
     * 逻辑删除管理员账号
     *
     * @param administrator
     */
    public void ChangeAdminStatus(Administrator administrator) {
        AdministratorMapper admin = MybatisUtils.getMapper(AdministratorMapper.class);
        admin.update(administrator);
    }

    /**
     * 查询所有管理员信息
     *
     * @return
     */
    public List<Administrator> getAllAdmin() {
        AdministratorMapper admin = MybatisUtils.getMapper(AdministratorMapper.class);
        return admin.getAll();
    }
}
