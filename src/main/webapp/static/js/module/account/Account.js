/**
 * @author weip
 * @date 2016-12-17
 */
Ext.define('Module.Account.GridPanel', {
    dataUrl     :  SysConfig.ctx + 'account/listByPage.do',
    extend 		: 'ExtUx.grid.CusGrid',
    xtype  		: 'accountgridpanel',
    rootVisible : false,
    initComponent : function() {
        /*this.on('itemclick', function(view, record, item, index, e, eOpts) {
            this.fireEvent('nodeClick', this, view, record);
        });*/
        this.callParent();
    },
    buildFields     : function() {
        return [
            'studentNo',
            'name',
            'gradeName',
            'studentId',
            'majorName'
        ];
    },
    buildColumns	: function() {
        return [
            {text : '学号', dataIndex : 'studentNo'},
            {text : '报名号', dataIndex : 'applyNo'},
            {text : '姓名', dataIndex : 'name'},
            {text : '身份证', dataIndex : 'idCardNo'},
            {text : '年级', dataIndex : 'gradeName'},
            {text : '学院', dataIndex : 'instituteName'},
            {text : '专业', dataIndex : 'majorName'},
            {text : '班级', dataIndex : 'className'}
        ];
    },
    buildTbar       : function() {
        return ['姓名：',{
            xtype         : 'textfield',
            itemId        : 'nameField',
            maxLength     : 20,
            width		  : 100,
            listeners     : {
                specialkey : this.onCheckEnterKeyFn,
                scope      : this
            }
        },{
            text     : '查询',
            itemId   : 'queryBtn',
            handler  : this.onQueryFn,
            scope    : this
        }];
    },
    onCheckEnterKeyFn  : function(field, e) {
        if (e.getKey() === e.ENTER) {
            this.list();
        }
    },

});
