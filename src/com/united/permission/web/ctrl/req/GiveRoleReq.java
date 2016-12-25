package com.united.permission.web.ctrl.req;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.CorpModuleRole;

/**
 * Created by turningOwei on 2016/12/25.
 */
public class GiveRoleReq {
    Account selectAccount;
    CorpModuleRole corpModuleRole;

    public Account getSelectAccount() {
        return selectAccount;
    }

    public void setSelectAccount(Account selectAccount) {
        this.selectAccount = selectAccount;
    }

    public CorpModuleRole getCorpModuleRole() {
        return corpModuleRole;
    }

    public void setCorpModuleRole(CorpModuleRole corpModuleRole) {
        this.corpModuleRole = corpModuleRole;
    }
}
