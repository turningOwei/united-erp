package com.united.permission.web.ctrl;

import com.global.ExtGrid;
import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.service.SysDeptRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/27.
 */
@Controller
@RequestMapping("/permission/deptrole")
public class SysDeptRoleCtrl {
    @Autowired
    private SysDeptRoleService sysDeptRoleService;
    @RequestMapping("/listNotGeneralManager.do")
    @ResponseBody
    public ExtGrid listNotGeneralManager(Account account){
        List<SysDeptRole> list = sysDeptRoleService.listNotGeneralMager(account.getDeptId());
        return new ExtGrid(list,0,true);
    }

}
