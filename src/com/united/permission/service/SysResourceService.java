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

    List<SysResource> getAll();

    /**
     * 查询角色拥有的资源菜单:查询所有资源,角色拥有的则为选中状态,否则不选中状态
     * @param roleId
     * @return
     */
    List<SysResource> listRoleResource(Long roleId);

}
