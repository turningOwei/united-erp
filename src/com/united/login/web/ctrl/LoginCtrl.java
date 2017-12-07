package com.united.login.web.ctrl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.corp.dao.entity.Company;
import com.united.corp.service.CompanyService;
import com.united.login.pojo.IndexResult;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.ResourceService;
import com.united.permission.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/login.do")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("view/login");
        return mv;
    }


    @RequestMapping("/index.do")
    public ModelAndView index(Account account,ModelMap modelMap,ServletWebRequest request,HttpSession httpSession){
        ModelAndView mv = new ModelAndView("view/index");


        //设置全局变量
        //公司code
        String corpCode = "123";
        Company corp = companyService.getByCorpCode(corpCode);
        modelMap.put("corp",corp);
        modelMap.put("corpId",corp.getOid());
        httpSession.setAttribute("corp",corp);
        httpSession.setAttribute("corpId",corp.getOid());


        //默认设置总经理登录
        account.setOid(1l);
        //判断是否登录
        Account accountEntity = accountService.getByOId(account.getOid());

        String ctx = request.getContextPath();
        modelMap.put("ctx", ctx);
        modelMap.put("staticPath", ctx+"/static");
        modelMap.addAttribute("account",account);
        IndexResult result = getResult(accountEntity);
        Gson gson = new GsonBuilder().serializeNulls().create();
        modelMap.put("result", gson.toJson(result));
        return mv;
    }

    private IndexResult getResult(Account account){
        IndexResult result = new IndexResult();
        SysResource rootNode = sysResourceService.getRootNode(account);
       /* Resource rootNode = resourceService.getRootNodeByAccount(account);
        result.setMenuData(rootNode);*/
        result.setMenuData(rootNode);
        return result;
    }


}
