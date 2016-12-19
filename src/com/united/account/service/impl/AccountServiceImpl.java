package com.united.account.service.impl;

import com.united.account.dao.AccountMapper;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.dao.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Resource getResourceByAccount(Account account) {
        return null;
    }

    @Override
    public List<Account> listByPage(Account account) {
        account.setCorpId(1);
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司Id不能为空");

        return  accountMapper.selectAllByCorp(account.getCorpId());
    }

    @Override
    public Integer listByPageCount(Account account) {
        account.setCorpId(1);
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司Id不能为空");

        return  accountMapper.selectAllByCorpCount(account.getCorpId());
    }
}
