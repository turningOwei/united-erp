package com.united.account.service.impl;

import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.dao.entity.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Resource getResourceByAccount(Account account) {
        return null;
    }
}
