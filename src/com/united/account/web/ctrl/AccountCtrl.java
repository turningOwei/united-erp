package com.united.account.web.ctrl;

import com.united.account.dao.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * Created by turningOwei on 2016/11/30.
 */
@Controller
@RequestMapping("/account")
public class AccountCtrl {
    @RequestMapping("/login.do")
    public ModelAndView login(Account account){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("ctx","testCtx");
        return mv;
    }
}
