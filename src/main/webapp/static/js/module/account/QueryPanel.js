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
            {text : '姓名',     dataIndex : 'name',width:200},
            {text : '联系电话', dataIndex : 'mobilePhone',width : 160},
            {text : '邮件地址', dataIndex : 'email',width:160},
            {text : '所属业务', dataIndex : 'bizModuleKey',width:160}
        ];
    },
    buildTbar       : function(){
        var thiz = this;
        var roleMangeListeners = {
            click:function(thisCmp, e, eOpts ){
                thiz.store.reload();
            }
        };
        var refrushListeners = {
            click:function(thisCmp, e, eOpts ){
                thiz.store.reload();
            }
        };
        return  [
            {xtype  : 'button',text : '刷新',listeners:refrushListeners    },
            {xtype  : 'button',text : '权限管理',listeners:roleMangeListeners}
        ];
    }
});
