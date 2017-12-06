package com.united.permission.dao;

import com.united.permission.dao.entity.CorpModuleRole;

public interface CorpModuleRoleMapper {
    int insert(CorpModuleRole record);

    int insertSelective(CorpModuleRole record);
}