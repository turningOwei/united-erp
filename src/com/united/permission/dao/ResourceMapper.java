package com.united.permission.dao;

import com.united.permission.dao.entity.Resource;
import com.united.permission.dao.entity.ResourceKey;

public interface ResourceMapper {
    int deleteByPrimaryKey(ResourceKey key);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(ResourceKey key);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}