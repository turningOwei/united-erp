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
    requires        : ['Module.account.AddOrEditWin','Module.permission.role.QueryPanel'],
    initComponent : function() {
        this.callParent();
    },
    buildFields     : function() {
        return [
            'id',
            'corpId',
            'name',
            'mobilePhone',
            'email',
            'bizModuleKey',
            'bizSuperadmin',
            'roleAliasName',
            'roleName'
        ];
    },
    buildColumns	: function() {
        return [
            {text : '姓名',     dataIndex : 'name',width:200},
            {text : '联系电话', dataIndex : 'mobilePhone',width : 160},
            {text : '邮件地址', dataIndex : 'email',width:160},
            {text : '所属业务', dataIndex : 'bizModuleKey',width:160},
            {text : '角色名称', dataIndex : 'roleName',width:160},
            {text : '权限别名(员工职称)', dataIndex : 'roleName',width:160}
        ];
    },
    buildTbar       : function(){
        var thiz = this;
        var refrushListeners = {
            click:function(thisCmp, e, eOpts ){
                thiz.store.reload();
            }
        };
        var gridAfterrender = function(thisCmp, eOpts ){
            //数据加载完后选择
            thisCmp.getStore().on('load',function(thisStore, records, successful, eOpts ){
                for(var i = 0;i < records.length;i++){
                    var record = records[i];
                    if(record.get('checked')){
                        thisCmp.getSelectionModel().select(i,false,false) ;
                    }
                }
            });
        };
        var roleMangeListeners = {
            click:function(thisCmp, e, eOpts ){
                var params = {
                        'selectAccount.id' : thiz.ownerGrid.getSp('id'),
                        'selectAccount.corpId' : thiz.ownerGrid.getSp('corpId'),
                        'selectAccount.bizModuleKey' : thiz.ownerGrid.getSp('bizModuleKey')
                };
                var saveParams;
                var win  = new ExtUx.window.SaveOnCloseWin({
                    width:700,height:400,modal:true,title         : '角色管理',
                    items         : {
                        xtype:'perminssionrolepanel',
                        //角色窗口中的gridpanel监听事件
                        listeners : {
                            checkboxSelect : function(thisCmp,selected){
                                if(selected.length !=0 ){
                                    var record = selected[0];
                                    saveParams = {
                                        corpModuleRole:{
                                            id : record.get('id'),
                                            moduleKey : record.get('moduleKey')
                                        }
                                    };
                                }else{
                                    saveParams = null;
                                }
                            },
                            afterrender : gridAfterrender
                        }
                    },
                    //角色窗口监听事件
                   listeners     : {
                        afterrender : function( thisCmp, eOpts ){
                            Ext.Function.defer(function(){
                                thisCmp.getComponent(0).load(params);
                            }, 400);
                        },
                        saveclick   : function(thisCmp,btn){
                            /*if(Ext.isEmpty(saveParams)){
                                return Msg.error('未选择角色!');
                            }*/
                            /*if(params.bizModuleKey != saveParams.moduleKey){
                                return Msg.error('业务模块不符合,请重新选择!');
                            }*/
                        }
                    }
                });
                win.show();
            }
        };
        var thiz = this;
        var accountEditListeners = {
            click:function(thisCmp, e, eOpts ){
                var params = {
                    id : thiz.ownerGrid.getSp('id'),
                    corpId : thiz.ownerGrid.getSp('corpId')
                };
                var win = new Module.account.AddOrEditWin({
                    width       :   300,
                    height      :   300,
                    title       : '账户修改',
                    listeners   : {
                        afterrender : function( thisCmp, eOpts ){
                            var cfg = {
                                url : SysConfig.ctx + '/account/queryAccountById.do',
                                params  : params
                            };

                            Ext.Function.defer(function(){
                                thisCmp.getComponent(0).load(cfg);
                            }, 500);
                        },
                        saveclick   : function(thisCmp,btn){
                            var cfg = {
                                url : SysConfig.ctx + '/account/saveAccount.do',
                            };
                            thisCmp.getComponent(0).submit(cfg);

                            /*Ext.Function.defer(function(){
                                thisCmp.close();
                                thiz.ownerGrid.getStore().reload();
                            }, 500);*/
                        }

                    }
                });

                win.show();
            }
        };
        this.accountAdd = Ext.id();
        this.accountEdit = Ext.id();
        this.roleEdit  = Ext.id();
        var accountAddListener = this.buildAccountAddListener();
        return  [
            {xtype  : 'button',text : '刷新',     listeners:refrushListeners    },
            {itemId : this.accountAdd,xtype  : 'button',text : '账户添加',disabled:false, listeners:accountAddListener},
            {itemId : this.roleEdit,xtype  : 'button',text : '角色管理',disabled:true, listeners:roleMangeListeners},
            {itemId : this.accountEdit,xtype  : 'button',text : '账户修改', disabled:true,listeners:accountEditListeners},
        ];
    },
    listeners : {
        rowclick:function(thisViewTable, record, tr, rowIndex, e, eOpts ){
            Util.getCmp(this.accountEdit).setDisabled(false);
            //总经理不能修改
            if(!(record.get('bizSuperadmin')==2)){
                Util.getCmp(this.roleEdit).setDisabled(false);
            }else{
                Util.getCmp(this.roleEdit).setDisabled(true);
            }
        }
    },

    buildAccountAddListener : function () {
        var listener = {
            click: function (thisCmp, e, eOpts) {
                var win = new Module.account.AddOrEditWin({
                    width       :   300,
                    height      :   300,
                    title       : '账户添加',
                    listeners   : {
                        /*afterrender : function( thisCmp, eOpts ){
                            var cfg = {
                                url : SysConfig.ctx + '/account/queryAccountById.do',
                                params  : params
                            };

                            Ext.Function.defer(function(){
                                thisCmp.getComponent(0).load(cfg);
                            }, 500);
                        },*/
                        saveclick   : function(thisCmp,btn){
                            var cfg = {
                                url : SysConfig.ctx + '/account/saveAccount.do',
                                success: function (form, action){
                                    alert(222);
                                }
                            };
                            console.log(thisCmp.getComponent(0));
                            thisCmp.getComponent(0).submit(cfg);

                           /* Ext.Function.defer(function(){
                                thisCmp.close();
                                thiz.ownerGrid.getStore().reload();
                            }, 500);*/
                        }

                    }
                });

                win.show();
            }
        }
        return listener;
    }

});
