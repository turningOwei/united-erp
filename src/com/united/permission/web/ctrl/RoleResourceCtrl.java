package com.united.permission.web.ctrl;

import com.global.ExtGrid;
import com.global.ExtJsonForm;
import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.RoleResServie;
import com.united.permission.service.SysDeptRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/16.
 */
@Controller
@RequestMapping("/permission/roleresource")
@SessionAttributes({"corp","corpId"})
public class RoleResourceCtrl {
    @Autowired
    private SysDeptRoleService sysDeptRoleService;
    @Autowired
    private RoleResServie roleResServie;
    /**
     * 超级管理员查询一般角色
     * @param dept
     * @return
     */
    @RequestMapping("/listNormalRoleByDept.do")
    @ResponseBody
    public ExtGrid listNormalRoleByDept(Long dept){
        List<SysDeptRole> list  = sysDeptRoleService.listNormalRoleByDept(dept);
        return new ExtGrid(list,0,true);
    }


    /**
     * 根据角色查询公司资源菜单
     * @param roleId
     * @param corpId
     * @return
     */
    @RequestMapping("/lisResourceByDeptRole.do")
    @ResponseBody
    public ExtGrid lisResourceByDeptRole(Long roleId,@ModelAttribute("corpId")Long corpId){
        List<SysResource> list = roleResServie.getSysResouceByCorpAndRole(corpId, roleId);
        return new ExtGrid(list,0,true);
    }


    @RequestMapping("/saveRoleResource.do")
    @ResponseBody
    public ExtJsonForm saveRoleResource(@ModelAttribute("corpId")Long corpId,Long roleId,Long[] resourceIds){
        if(roleId==null){
            return new ExtJsonForm(true,"角色未点选,无法保存!");
        }
        roleResServie.saveRoleResource(corpId,roleId,resourceIds);
        return new ExtJsonForm(true,"保存成功");
    }
}
