package com.united.account.web.ctrl;

import com.global.ExtJsonForm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.page.PageParam;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
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
    public String listByPage(Account account,PageParam<Account> pageParam){
        List<Account> list = accountService.listByPage(account);
        Integer totalCount =  accountService.listByPageCount(account);
        pageParam.setList(list);
        Gson gson = new GsonBuilder().serializeNulls().create();
        Map map = new HashMap();
        map.put("data",list);
        map.put("totalCount",totalCount);
        map.put("success",true);
        String result = gson.toJson(map);
        return result;
    }

    @RequestMapping("/queryAccountById.do")
    @ResponseBody
    public ExtJsonForm queryAccountById(Account account) {
        Account entity = accountService.queryAccountById(account);
        return new ExtJsonForm(true,entity);
    }

    @RequestMapping("/saveAccount.do")
    @ResponseBody
    public ExtJsonForm saveAccount(Account account) {
        Account entity = accountService.saveOrUpdateAccount(account);
        return new ExtJsonForm(true,entity);
    }


}
