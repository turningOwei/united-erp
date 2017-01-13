package com.united.manager.web.ctrl;

import com.global.ExtGrid;
import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/12.
 */
@Controller
@RequestMapping("/permission/managesysresource")
public class ManageSysReSourceCtrl {
    @Autowired
    private SysResourceService sysResourceService;
    @RequestMapping("/list.do")
    @ResponseBody
    public ExtGrid list(Account account){
        List<SysResource> list = sysResourceService.getAll();
        return new ExtGrid(list,list.size(),true);
    }
}
