package designer.sys;

import com.common.gsonutil.GsonUtil;
import com.united.designer.dao.entity.SysDesignerItem;
import com.united.designer.service.SysDesignerItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 002465 on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysDesignerItemTest {
    @Autowired
    private SysDesignerItemService sysDesignerItemService;

    @Test
    public void testQuery(){
        List<SysDesignerItem> list = sysDesignerItemService.getAll();
        System.out.println("list.size:"+GsonUtil.create().toJson(list));

    }

    @Test
    public void testInsert(){
        SysDesignerItem entity = new SysDesignerItem();
        entity.setItemName("test1");
        entity.setItemUnit("test12");
        entity.setItemUnitPrice("200");
        entity.setItemTypeCode(111l);
        sysDesignerItemService.saveOrUpdate(entity);
    }

}
