package com.united.corp.web.ctrl;

import com.global.ExtGrid;
import com.united.account.dao.entity.Account;
import com.united.corp.dao.entity.CorpDept;
import com.united.corp.dao.entity.SysDepartment;
import com.united.corp.service.CorpDeptService;
import com.united.corp.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/30.
 */
@Controller
@RequestMapping("/corp/department")
public class DepartmentCtrl {
    @Autowired
    private CorpDeptService corpDeptService;
    @Autowired
    private SysDepartmentService sysDepartmentService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ExtGrid listByPage(Account account){
        account.setCorpId(1l);
        List<CorpDept> list = corpDeptService.list(account.getCorpId());
        return new ExtGrid(list,list.size(),true);
    }


    @RequestMapping("/listAll.do")
    @ResponseBody
    public ExtGrid listViewByCorpId(Account account){
        account.setCorpId(1l);
        List<SysDepartment> list = sysDepartmentService.listAll();
        return new ExtGrid(list,list.size(),true);
    }

}
