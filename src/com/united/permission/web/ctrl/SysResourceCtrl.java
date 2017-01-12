package com.united.permission.web.ctrl;

import com.global.ExtGrid;
import com.united.account.dao.entity.Account;
import com.united.permission.service.SysResourceService;
import com.united.permission.web.ctrl.req.GiveRoleReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Controller
@RequestMapping("/permission/sysresource")
public class SysResourceCtrl {
    @Autowired
    private SysResourceService sysResourceService;
    @RequestMapping("/getRoot.do")
    @ResponseBody
    public ExtGrid listNotGeneralManager(Account account,GiveRoleReq req){
        Account selectAccount = req.getSelectAccount();
        sysResourceService.getRootNode(null);
        return null;
    }

}
