package com.united.permission.service;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.SysResource;

/**
 * Created by turningOwei on 2016/12/17.
 */
public interface ResourceService {
    public SysResource getRootNodeByAccount(Account account);
}
