/**
 * @author weip
 * @date 2016-12-17
 */
Ext.define('Module.account.QueryPanel', {
    dataUrl     :  SysConfig.ctx + '/account/listByPage.do',
    extend 		: 'ExtUx.grid.CusGrid',
    xtype  		: 'accountgquerypanel',
    isQueryPage : true,
    //bbar    	: [{xtype       : 'pagingtoolbar', store : this.store, displayInfo : true}],
    plugins: {ptype: 'cellediting', clicksToEdit: 1},
    rootVisible : false,
    initComponent : function() {
        /*this.on('itemclick', function(view, record, item, index, e, eOpts) {
         this.fireEvent('nodeClick', this, view, record);
         });*/
        this.callParent();
    },
    buildFields     : function() {
        return [
            'name',
            'mobilePhone',
            'email',
            'bizModuleKey'
        ];
    },
    buildColumns	: function() {
        return [
            {text : '姓名',     dataIndex : 'name'},
            {text : '联系电话', dataIndex : 'mobilePhone'},
            {text : '邮件地址', dataIndex : 'email'},
            {text : '所属业务', dataIndex : 'bizModuleKey'}
        ];
    }
});
