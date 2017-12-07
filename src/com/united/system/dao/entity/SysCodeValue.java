package com.united.system.dao.entity;

import com.dao.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author 002465
 * @date 2017/12/7
 */
@Entity
@Table(name="SYS_CODE_VALUE")
@Data
public class SysCodeValue extends BaseEntity{
    /**oid作为用途编码*/

    /**用途名称*/
    @Column(name = "code_name")
    private String codeName;

    /**用途类别名称*/
    @Column(name = "code_type_name")
    private String codeTypeName;

    /**用途类别id*/
    @Column(name = "code_type_id")
    private Long codeTypeId;


    public static SysCodeValue createBugetTempalte(){
        SysCodeValue entity = new SysCodeValue();
        entity.setCodeTypeId(1L);
        entity.setCodeTypeName("预算模板");
        return entity;
    }
}
