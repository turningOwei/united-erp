package com.united.account.service.impl;

import com.united.account.dao.AccountDao;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysDeptRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SysDeptRoleService sysDeptRoleService;

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
            if(entity.getSysDeptRole()!=null)
                entity.setRoleName(entity.getSysDeptRole().getName());
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
        if(StringUtils.isEmpty(account.getPwd())){
            account.setPwd("123456");
        }
        accountDao.saveOrUpdate(account);
        return account;
    }

    @Override
    /**
     * 验证公司部门超级管理员是否存在
     */
    public boolean validDeptSuperAdminExist(Account account) {
        SysDeptRole superAdmin = sysDeptRoleService.getDeptSuperAdmin(account.getDeptId());
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("corpId",account.getCorpId());

        paramMap.put("deptRoleId",superAdmin.getOid());
        /**
         * 添加非超级管理员判断
         */
        if(!account.getDeptRoleId().equals(superAdmin.getOid())){
            return false;
        }
        List<Account> list = accountDao.getListEquals(paramMap);
        if(list!=null&&list.size()>0)
            return true;
        return false;
    }
}
