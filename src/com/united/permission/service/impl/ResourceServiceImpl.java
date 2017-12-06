package com.united.permission.service.impl;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.SysResourceDao;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/17.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    private SysResourceDao sysResourceDao;

    @Override
    public SysResource getRootNodeByAccount(Account account) {
        account.setCorpId(1l);
        account.setOid(1l);
        Assert.notNull(account,"账户不能为空");
        Assert.notNull(account.getCorpId(),"公司ID能为空");
        Assert.notNull(account.getOid(),"公司ID能为空");
        SysResource root = sysResourceDao.getRootSysource();
        List<SysResource> list = sysResourceDao.getAll();
        if(list!=null&&list.size() > 0){
            root = fillChildren(list,root);
        }
        return root;
    }

    private SysResource fillChildren(List<SysResource> list,SysResource node){
        List<SysResource> children = new ArrayList<>();
        for (SysResource resource : list) {
            if(node.getOid().equals(resource.getParentId())){
                resource = fillChildren(list,resource);
                children.add(resource);
            }
        }
        node.setChildren(children);
        return node;
    }
}
