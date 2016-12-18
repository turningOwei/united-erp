package com.united.permission.dao;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.Resource;
import com.united.permission.dao.entity.ResourceKey;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(ResourceKey key);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(ResourceKey key);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    public List<Resource> selectAllByCorp(Account account);

    Resource selectRootByCorp(Integer corpId);
}