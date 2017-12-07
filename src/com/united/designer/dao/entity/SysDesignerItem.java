package com.united.designer.dao.entity;

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
@Table(name = "sys_designer_item")
@Data
public class SysDesignerItem extends BaseEntity {
    @Column(name="item_type_code")
    private Long itemTypeCode;
    @Column(name="item_name")
    private String itemName;
    @Column(name="item_unit")
    private String itemUnit;
    @Column(name="item_unit_price")
    private String itemUnitPrice;
    /**备注*/
    @Column(name = "memo")
    private String memo;
}
