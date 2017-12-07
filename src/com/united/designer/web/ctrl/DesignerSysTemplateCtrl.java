package com.united.designer.web.ctrl;

import com.global.ExtGrid;
import com.united.permission.dao.entity.SysDeptRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 002465 on 2017/12/7.
 */
@Controller
@RequestMapping("/designer/systempate")
public class DesignerSysTemplateCtrl {
    @RequestMapping("/listByPage.do")
    @ResponseBody
    public ExtGrid listByPage(String itemTypeCode){
        /*List<SysDeptRole> list  = sysDeptRoleService.listNormalRoleByDept(dept);
        return new ExtGrid(list,0,true);*/
        return null;
    }
}
