package com.united.manager.web.ctrl;

import com.global.ExtGrid;
import com.global.ExtJsonForm;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import com.united.permission.service.SysRoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/13.
 */
@Controller
@RequestMapping("/permission/managesysroleres")
public class ManageSysRoleResCtrl {
    @Autowired
    private SysRoleResService sysRoleResService;

    @Autowired
    private SysResourceService sysResourceService;
    @RequestMapping("/listRoleResource.do")
    @ResponseBody
    public ExtGrid listRoleResource(Long roleId){
        //List<SysRoleRes> list = sysRoleResService.getListByRole(roleId);
        if(roleId == null){
            return new ExtGrid(null,0,true);
        }
        List<SysResource> list = sysResourceService.listRoleResource(roleId);
        return new ExtGrid(list,list.size(),true);
    }

    @RequestMapping("/saveRoleResource.do")
    @ResponseBody
    public ExtJsonForm saveRoleResource(Long roleId,Long[] resourceIds){
        if(roleId==null){
            return new ExtJsonForm(true,"角色未点选,无法保存!");
        }
        sysRoleResService.saveRoleResource(roleId,resourceIds);
        return new ExtJsonForm(true,"保存成功");
    }
}
