package com.united.login.web.ctrl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.login.pojo.IndexResult;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.portlet.ModelAndView;

/**
 * Created by turningOwei on 2016/12/1.
 */
@Controller
@RequestMapping
public class LoginCtrl {
    @Autowired
    private SysResourceService sysResourceService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/index.do")
    public ModelAndView login(Account account,ModelMap modelMap,ServletWebRequest request){
        ModelAndView mv = new ModelAndView("view/index");
        String ctx = request.getContextPath();
        modelMap.put("ctx", ctx);
        modelMap.put("staticPath", ctx+"/static");
        IndexResult result = getResult(account);
        Gson gson = new GsonBuilder().serializeNulls().create();
        modelMap.put("result", gson.toJson(result));
        return mv;
    }

    private IndexResult getResult(Account account){
        IndexResult result = new IndexResult();
        SysResource rootNode = sysResourceService.getRootNode();
        result.setMenuData(rootNode);
        return result;
    }
}
