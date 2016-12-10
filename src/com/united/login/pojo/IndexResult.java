package com.united.login.pojo;

import com.united.permission.dao.entity.SysResource;
import com.united.permission.dao.entity.SysUser;

/**
 * Created by turningOwei on 2016/12/8.
 */
public class IndexResult {
    private SysResource menuData;
    private SysUser sysUser;

    public SysResource getMenuData() {
        return menuData;
    }

    public void setMenuData(SysResource menuData) {
        this.menuData = menuData;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
