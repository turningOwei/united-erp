Ext.define('Module.manage.SysRoleManage', {
    extend 		: 'Ext.panel.Panel',
    xtype  		: 'managesysrolemanage',
    requires    : ['Module.manage.RoleQry','Module.manage.SysResourceQry'],
    initComponent : function() {
        this.callParent();
    },
    layout: {
        type: 'border',
        regionWeights: {
            west: 20,
            north: 10,
            south: -10,
            east: -20
        }
    },
    items: [{
        title: '角色',
        region: 'center',     // center region is required, no width/height specified
        xtype: 'manageroleqry',
        split: true,
        layout: 'fit',
        margin: '5 5 0 0',
        listeners : {
            rowclick:function( thisGrid, record, tr, rowIndex, e, eOpts ){
                var resCmp = Util.getCmp('sysrolemange-resourceid');
                resCmp.setCollapsed(false);
                var defaultParams = {
                    roleId : record.get('oid')
                };
                resCmp.loadByDefaultParams(defaultParams);
            }
        }
    },{
        itemId:'sysrolemange-resourceid',
        title: '资源(菜单)',
        region:'east',
        selModel:{
            selType : 'checkboxmodel',
            mode    : 'MULTI'
        },
        xtype: 'managesysresourceqry',
        margin: '5 0 0 5',
        width: 600,
        split: true,
        collapsed : false, //展开资源panel
        collapsible: true,   // make collapsible
        layout: 'fit',
        buildTbar : function(){
            this.roleResourceAdd = Ext.id();
            var refrushListeners = {};
            var accountAddListener = {};
            return  [
                {xtype  : 'button',text : '刷新',     listeners : refrushListeners    },
                {itemId : this.roleResourceAdd,xtype  : 'button',text : '保存',disabled:false, listeners:accountAddListener}
            ];
        },
        listeners : {
            afterrender : function( thisGrid, eOpts ){
                thisGrid.getStore().on('load',function(thisStore, records, successful, eOpts ){
                    var sm  = thisGrid.getSelectionModel();
                    /**
                     * 选中重置
                     */
                    sm.deselectAll();

                    for(var i = 0;i < records.length;i++){
                        if(records[i].get('checkFlag')){
                            /**
                             * 保留之前的选择,
                             * 触发选中事件
                             */
                            sm.select(i,true,false);
                        }
                    }
                },this);
            }
        }
    }]

});