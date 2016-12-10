package com.united.permission.dao;

import com.united.permission.dao.entity.SysResource;

import java.util.List;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Integer dbId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer dbId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    SysResource selectRoot();

    List<SysResource> selectAll();
}