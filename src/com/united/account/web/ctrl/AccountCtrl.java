package com.united.account.web.ctrl;

import com.global.ExtGrid;
import com.global.ExtJsonForm;
import com.page.PageParam;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by turningOwei on 2016/11/30.
 */
@Controller
@RequestMapping("/account")
public class AccountCtrl {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login.do")
    public ModelAndView login(Account account){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("ctx","testCtx");
        return mv;
    }

    @RequestMapping("/listByPage.do")
    @ResponseBody
    public ExtGrid listByPage(Account account,PageParam<Account> pageParam){
        List<Account> list = accountService.listByPage(account);
        Integer totalCount =  accountService.listByPageCount(account);
        pageParam.setList(list);
        return new ExtGrid(list,totalCount,true);
    }

    @RequestMapping("/queryAccountById.do")
    @ResponseBody
    public ExtJsonForm queryAccountById(Account account) {
        Account entity = accountService.getByOId(account.getOid());
        if(entity.getSysDepartment()!=null){
            entity.setDepartmentName(entity.getSysDepartment().getName());
        }
        if(entity.getSysDeptRole()!=null)
            entity.setRoleName(entity.getSysDeptRole().getName());
        return new ExtJsonForm(true,entity);
    }

    @RequestMapping("/saveAccount.do")
    @ResponseBody
    public ExtJsonForm saveAccount(Account account,ModelMap modelMap,HttpSession httpSession) {

        Long corpId = Long.parseLong(httpSession.getAttribute("corpId").toString());
        account.setCorpId(corpId);
        //验证 超级管理员唯一
        boolean valid = accountService.validDeptSuperAdminExist(account);
        if(valid){
            return new ExtJsonForm(false,"该部门超级管理员已添加!");
        }
        Account entity = accountService.saveOrUpdateAccount(account);
        return new ExtJsonForm(true,entity);
    }


}
