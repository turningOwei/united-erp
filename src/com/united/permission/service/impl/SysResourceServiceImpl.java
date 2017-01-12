package com.united.permission.service.impl;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.SysResourceDao;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.SysResourceService;
import com.united.permission.service.SysRoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysRoleResService sysRoleResService;

    public SysResource getRootNode(Account account){
        SysResource root = sysResourceDao.getRootSysource();

        //List<SysRoleRes> list = sysRoleResService.getListByRole(account.getAccountRole().getDeptRoleId());

        //List<SysResource> list = sysResourceDao.list();
        List<SysResource> list = this.getListByAccount(account);
        if(list!=null&&list.size() > 0){
            root = fillChildren(list,root);
        }
        return root;
    }



    private SysResource  fillChildren(List<SysResource> list,SysResource node){
        List<SysResource> children = new ArrayList<>();
        for (SysResource sysResource : list) {
            if(node.getOid().equals(sysResource.getParentId())){
                sysResource = fillChildren(list,sysResource);
                children.add(sysResource);
            }
        }
        node.setChildren(children);
        return node;
    }


    @Override
    public List<SysResource> getListByAccount(Account account) {
        List<SysResource> list = new ArrayList<SysResource>();
        Assert.notNull(account);

        if(account.getDeptRoleId()==null)
            return list;

        List<SysRoleRes> sysRoleResList = sysRoleResService.getListByRole(account.getDeptRoleId());
        if(sysRoleResList!=null&&sysRoleResList.size()>0){
            for (SysRoleRes sysRoleRes : sysRoleResList) {
                list.add(sysRoleRes.getSysResource());
            }
        }
        return list;
    }
}
