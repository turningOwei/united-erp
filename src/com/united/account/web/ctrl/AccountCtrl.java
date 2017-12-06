package com.united.account.web.ctrl;

import com.global.ExtGrid;
import com.global.ExtJsonForm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.page.PageParam;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.dao.entity.CorpModuleRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Account entity = accountService.queryAccountById(account);
        return new ExtJsonForm(true,entity);
    }

    @RequestMapping("/saveAccount.do")
    @ResponseBody
    public ExtJsonForm saveAccount(Account account,CorpModuleRole corpModuleRole) {
        Account entity = accountService.saveOrUpdateAccount(account);
        return new ExtJsonForm(true,entity);
    }


}
