package com.united.designer.web.ctrl;

import com.global.ExtGrid;
import com.united.designer.dao.entity.SysDesignerItem;
import com.united.designer.service.SysDesignerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 002465 on 2017/12/7.
 */
@Controller
@RequestMapping("/designer/sysitem")
public class SysDesignerItemCtrl {
    @Autowired
    private SysDesignerItemService sysDesignerItemService;

    @RequestMapping("/listByPage.do")
    @ResponseBody
    public ExtGrid listByPage(String itemTypeCode){
        List<SysDesignerItem> list = sysDesignerItemService.getAll();
        return new ExtGrid(list,0,true);
    }
}
