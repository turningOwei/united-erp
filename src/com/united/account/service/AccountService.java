package com.united.account.service;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.Resource;

/**
 * Created by turningOwei on 2016/12/8.
 */
public interface AccountService {

    public Resource getResourceByAccount(Account account);

}
