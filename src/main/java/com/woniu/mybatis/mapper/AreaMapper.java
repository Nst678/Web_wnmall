package com.woniu.mybatis.mapper;

import com.woniu.mybatis.entity.Area;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/23
 * @描述
 */
public interface AreaMapper {

    /**
     * 根据父ID查询行政区
     * @param pid
     */
    List<Area> getByPid(int pid);
}
