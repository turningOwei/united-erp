package com.united.account.service.impl;

import com.united.account.dao.AccountDao;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.dao.entity.SysResource;
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
    private AccountDao accountDao;

    @Override
    public SysResource getResourceByAccount(Account account) {
        return null;
    }

    @Override
    public List<Account> listByPage(Account account) {
        account.setCorpId(1l);
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司Id不能为空");
        List<Account> list = accountDao.getList("corpId", account.getCorpId());
        for (Account entity : list) {
            if(entity.getSysDepartment()!=null)
                entity.setDepartmentName(entity.getSysDepartment().getName());
        }
        return  list;
    }

    @Override
    public Integer listByPageCount(Account account) {
        account.setCorpId(1l);
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司Id不能为空");
        return  10;
    }

    @Override
    public Account getByOId(Long oid) {
        return  accountDao.get(oid);
    }

    @Override
    public Account saveOrUpdateAccount(Account account) {
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司Id不能为空");
        accountDao.saveOrUpdate(account);
        return account;
    }
}
