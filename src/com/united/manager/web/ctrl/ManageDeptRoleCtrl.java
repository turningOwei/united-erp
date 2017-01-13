package com.united.manager.web.ctrl;

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
 * Created by turningOwei on 2017/1/12.
 */
@Controller
@RequestMapping("/permission/managedeptrole")
public class ManageDeptRoleCtrl {
    @Autowired
    private SysDeptRoleService sysDeptRoleService;
    @RequestMapping("/list.do")
    @ResponseBody
    public ExtGrid list(Account account){
        List<SysDeptRole> list = sysDeptRoleService.getAll();
        return new ExtGrid(list,list.size(),true);
    }
}
