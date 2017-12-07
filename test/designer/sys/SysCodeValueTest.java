package designer.sys;

import com.united.system.dao.entity.SysCodeValue;
import com.united.system.service.SysCodeValueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 002465 on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysCodeValueTest {
    @Autowired
    private SysCodeValueService sysItemService;

    @Test
    public void testInsert(){
        SysCodeValue sysItem1 = SysCodeValue.createBugetTempalte();
        sysItem1.setCodeName("厨房");
        sysItem1.setDelFlag(0);
        sysItemService.saveOrUpdate(sysItem1);

        SysCodeValue sysItem2 = SysCodeValue.createBugetTempalte();
        sysItem2.setCodeName("卫生间");
        sysItem2.setMemo("备注11");
        sysItemService.saveOrUpdate(sysItem2);
    }
}
