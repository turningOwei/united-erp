package com.united.permission.web.ctrl;

import com.global.ExtGrid;
import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.CorpModuleRole;
import com.united.permission.service.CorpModuleRoleService;
import com.united.permission.web.ctrl.req.GiveRoleReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/22.
 */
@Controller
@RequestMapping("/permission/role")
public class RoleCtrl {
    @Autowired
    private CorpModuleRoleService corpModuleRoleService;
    @RequestMapping("/listNotGeneralManager.do")
    @ResponseBody
    public ExtGrid listNotGeneralManager(Account account,GiveRoleReq req){
        account.setCorpId(1l);
        Account selectAccount = req.getSelectAccount();
        List<CorpModuleRole> list = corpModuleRoleService.listNotGeneralManager(account.getCorpId());
        return new ExtGrid(list,list.size(),true);
    }

    /**
     * 根据公司Id,选中账户Id,业务模块查询角色
     * @param account
     * @param req
     * @return
     */
    @RequestMapping("/listRoleByCorpIdAndAccountId.do")
    @ResponseBody
    public ExtGrid listRoleByCorpIdAndAccountId(Account account,GiveRoleReq req){
        Account selectAccount = req.getSelectAccount();
        List<CorpModuleRole> list = corpModuleRoleService.listRole(selectAccount.getCorpId(), selectAccount.getId(), selectAccount.getBizModuleKey());
        return new ExtGrid(list,list.size(),true);
    }

}
