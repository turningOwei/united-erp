/**
 * @author tangL
 * @date 2014-10-29
 */
Ext.define('App.TopPanel', {
    extend : 'Ext.toolbar.Toolbar',
    xtype  : 'apptoppanel',
    header  : {
        titlePosition : 2,
        titleAlign    : 'center'
    },
    initComponent : function() {
    	this.items = this.buildItems();
    	this.callParent();
    },
    initData   : function(data){
    	var userName   		= data.realName,
   			msg 	   		= Ext.String.format('你好 {0}, 欢迎登录', userName),
   			display    		= this.getComponent('display');
		display.setText(msg);
    },
    buildItems : function() {
    	return [{
    			xtype  	: 'label',
    			itemId	: 'display'	
    		},{
    			text	: '修改密码',
    			iconCls : 'user-edit',
    			handler : App.editLogin,
    			scope	: this
    		},{
    			text    : '注销',
    			iconCls : 'logout',
    			handler : App.logout,
    			scope   : this
    		}/*, '->', {
				text : 'POS签到',
				handler : App.posSign,
				scope : this
			}, {
				text : 'POS结算',
				handler : App.posSettle,
				scope : this
			} , '<a href="'+SysConfig.ctx+'/static/umsocx.rar">POS控件</a>'*/
    	];
    }
});
