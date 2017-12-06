package com.united.login.pojo;

import com.united.permission.dao.entity.SysUser;

/**
 * Created by turningOwei on 2016/12/8.
 */
public class IndexResult {
    private Object menuData;
    private SysUser sysUser;


    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Object getMenuData() {
        return menuData;
    }

    public void setMenuData(Object menuData) {
        this.menuData = menuData;
    }
}
