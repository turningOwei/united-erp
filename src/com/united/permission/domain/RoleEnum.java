package com.united.permission.domain;

import com.united.account.dao.entity.Account;

/**
 * Created by turningOwei on 2017/1/9.
 */
public enum RoleEnum {
    //与SYS_ROLE对应总经理
    GeneralManagerRole(1l);


    private Long oid;

    private RoleEnum(Long oid){
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    /**
     * 判断是总经理
     * @param account
     * @return
     */
    public static boolean isGeneralManager(Account account){
        if(account!=null
                &&account.getDeptRoleId()!=null
                &&account.getDeptRoleId().equals(GeneralManagerRole.getOid()))
            return  true;
        return false;
    }

    public static boolean isSuperAdmin(Account account){
        if(account!=null
                &&account.getSysDeptRole()!=null
                &&account.getSysDeptRole().getIsSuperAdmin()){
            return  true;
        }
        return false;
    }
}
