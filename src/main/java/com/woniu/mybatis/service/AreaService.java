package com.woniu.mybatis.service;

import com.woniu.mybatis.entity.Area;
import com.woniu.mybatis.mapper.AreaMapper;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/27
 * @描述
 */
public class AreaService {
    /**
     * 根据父ID查询省市区
     * @param pid
     * @return
     */
    public List<Area> getArea(int pid){
        AreaMapper areaMapper = MybatisUtils.getMapper(AreaMapper.class);
        return areaMapper.getByPid(pid);
    }
}
