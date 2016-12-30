package com.united.permission.dao;

import com.united.permission.dao.entity.ModuleRole;

import java.util.List;

public interface ModuleRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleRole record);

    int insertSelective(ModuleRole record);

    ModuleRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleRole record);

    int updateByPrimaryKey(ModuleRole record);


    public List<ModuleRole> listNotGeneralManager();
}