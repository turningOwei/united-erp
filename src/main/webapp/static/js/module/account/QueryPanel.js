/**
 * @author weip
 * @date 2016-12-17
 */
Ext.define('Module.account.QueryPanel', {
    dataUrl     :  SysConfig.ctx + '/account/listByPage.do',
    extend 		: 'ExtUx.grid.CusGrid',
    xtype  		: 'accountgquerypanel',
    isQueryPage : true,
    plugins     : {ptype: 'cellediting', clicksToEdit: 1},
    rootVisible : false,
    requires        : ['Module.account.AddOrEditWin'],
    initComponent : function() {
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
        var refrushListeners = {
            click:function(thisCmp, e, eOpts ){
                thiz.store.reload();
            }
        };
        var roleMangeListeners = {
            click:function(thisCmp, e, eOpts ){
                var win = new ExtUx.window.SaveOnCloseWin({
                    width:200,height:200,modal:true,title         : '权限管理',
                    items         : {xtype:'accountaddoreditform'}
                });
                win.show();
            }
        };
        var accountEditListeners = {
            click:function(thisCmp, e, eOpts ){
                var win = new Module.account.AddOrEditWin({
                    width:300,height:200,title         : '账户修改',
                    listeners : {
                        afterrender : function( thisCmp, eOpts ){
                            var cfg = {
                                url : SysConfig.ctx + '/account/listByPage.do'
                            };

                            Ext.Function.defer(function(){
                                thisCmp.getComponent(0).load(cfg);
                            }, 50);
                        }
                    }
                });

                win.show();
            }
        };
        this.accountEdit = Ext.id();
        return  [
            {xtype  : 'button',text : '刷新',     listeners:refrushListeners    },
            {xtype  : 'button',text : '权限管理', listeners:roleMangeListeners},
            {itemId : this.accountEdit,xtype  : 'button',text : '账户修改', disabled:true,listeners:accountEditListeners},
        ];
    },
    listeners : {
        rowclick:function(thisViewTable, record, tr, rowIndex, e, eOpts ){
            Util.getCmp(this.accountEdit).setDisabled(false);
        }
    }
});
