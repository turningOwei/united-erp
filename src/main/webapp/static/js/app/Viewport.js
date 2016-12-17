/**
 * @author tangL
 * @date 2014-10-29
 */
Ext.define('App.Viewport',{
	extend          : 'Ext.Viewport',
	layout          : 'border',
    requires        : ['App.MainPanel', 'App.TopPanel', 'App.WestPanel'],
    defaults		: {border:false},
	initComponent   : function() {
		this.items = [this.buildWestPanel(),   this.buildMainPanel(), this.buildTopPanel()];
		this.callParent();
	},
	initData       : function(data) {
		var westPanel = this.getComponent('westPanel'),
			topPanel  = this.getComponent('topPanel'),
			menuData  = data.menuData,
			sysUser	  = data.sysUser || {};


		var root = {
			text	  : '菜单',
			allowDrag : true,
			checked	  : true,
			depth     : 0,
			leaf	  : false,
			isFirst : false,
			qtip	  : 'root',
			root	  : true,
			expanded  : true,
			children  : [
				{text	  : '菜单'}
			]
		};
		console.log(menuData);
		//westPanel.loadData(root);
		westPanel.loadData(menuData);
		topPanel.initData(sysUser);
	},
	buildWestPanel : function() {
		return {
			title       : '系统菜单',
			xtype       : 'appwestpanel',
			region 		: 'west',
			itemId  	: 'westPanel',
			split    	: true,
            collapsible : true,
            defaults    : {border:false},
			width  		: 200,
			listeners   : {
				'nodeClick' : this.westPanelMenuClickFn,
				scope       : this
			}
		};
	},
	buildTopPanel  : function() {
		return {
			xtype     : 'apptoppanel',
			region    : 'north',
			height    : 40,
			itemId    : 'topPanel'		
		};
	},
	buildMainPanel : function() {
		return {
			xtype     : 'appmainpanel',
			region    : 'center',
			itemId 	  : 'mainPanel',
		};
	},
	/**
	 * 点击左边菜单事件处理
	 * 1.获取当前菜单节点数据
	 * 2.把菜单节点数据传入到mainPanel
	 * @param westPanel 
	 * @param view Ext.view.View
	 * @param record Ext.data.Model
	 */
	westPanelMenuClickFn : function(westPanel, view, record) {
		var mainPanel = this.getComponent('mainPanel'),
			menuData  = record.data;
		mainPanel.addMenu(menuData);
	}
});