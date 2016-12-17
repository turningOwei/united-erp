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
            {text : 'ѧ��', dataIndex : 'studentNo'},
            {text : '������', dataIndex : 'applyNo'},
            {text : '����', dataIndex : 'name'},
            {text : '���֤', dataIndex : 'idCardNo'},
            {text : '�꼶', dataIndex : 'gradeName'},
            {text : 'ѧԺ', dataIndex : 'instituteName'},
            {text : 'רҵ', dataIndex : 'majorName'},
            {text : '�༶', dataIndex : 'className'}
        ];
    },
    buildTbar       : function() {
        return ['������',{
            xtype         : 'textfield',
            itemId        : 'nameField',
            maxLength     : 20,
            width		  : 100,
            listeners     : {
                specialkey : this.onCheckEnterKeyFn,
                scope      : this
            }
        },{
            text     : '��ѯ',
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
