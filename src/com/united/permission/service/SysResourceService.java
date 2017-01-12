package com.united.permission.service;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.SysResource;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/8.
 */
public interface SysResourceService {
    public SysResource getRootNode(Account account);

    public List<SysResource> getListByAccount(Account account);

}
