Ext.define('Sos.jni.module.toDeal.ToDealPanel', {
	extend: 'Ext.grid.Panel',
	xtype : 'toDealPanel',
	requires: [
		'Sos.jni.module.toDeal.ToDealStore'
	],
	initComponent : function() {
		this.callParent();
	},
	title: '处理方式',

	store  : {
		type: 'toDealStore'
	},

	tbar   : [
		{xtype: 'button', text: '刷新',
			listeners:{
				'click' : function(thiz,e,eOpts){
					var thisPanel = thiz.ownerCt.ownerCt;
					thisPanel.getStore().reload();
				}
			}
		},
		{xtype: 'button', text: '添加',disabled:true,
			listeners: {
				'click': function(thiz,e,eOpts){
					var thisPanel = thiz.ownerCt.ownerCt;
					thisPanel.getStore().add({});
				}
			}},
		{xtype: 'button',disabled:true, text: '保存',listeners:{
			click : function(thiz,e,eOpts){
				var cmp = thiz.ownerCt.ownerCt;
				var updateModels = cmp.getStore().getUpdatedRecords();
				var newModels = cmp.getStore().getNewRecords();
				var updateRecords= [];
				var newRecords = [];
				for(var model in updateModels){
					var rec = updateModels[model].getData();
					updateRecords.push(rec);
				}
				for(var model in newModels){
					var rec = newModels[model].getData();
					rec.id = null;
					newRecords.push(rec);
				}
				if(updateRecords.length == 0 && newRecords == 0){
					var mb = Ext.MessageBox.alert('警告','未进行编辑或者添加操作!');
					return mb;
				}
				var params = {
					updateStr  : Ext.encode(updateRecords),
					newStr      : Ext.encode(newRecords),
				};
				Ext.Ajax.request({
					url     : contextPath+'/vdpgRlRule/saveModifed',
					params  : params,
					success : function(response, opts) {
						Ext.MessageBox.alert('信息','保存成功!');
						cmp.getStore().reload();
					},

					failure: function(response, opts) {
						Ext.MessageBox.alert('信息','保存失败!');
						console.log('server-side failure with status code ' + response.status);
					}
				});
			}
		}}
	],
	columns: [
		{text: '处理名称key', dataIndex: 'toDeal', width: 100},
		{text: '处理名称', dataIndex: 'dealName',   width: 150},
		{text: '备注',dataIndex: 'memo',width: 300}
	],

	listeners: {
		select     : 'onItemSelected',
		/*rowclick : function( thiz , record , tr , rowIndex , e , eOpts){
		 console.log(this.getStore());
		 },*/
		afterlayout: function (thiz, layout, eOpts) {
			//console.log(this.getStore());
		}
	},
	plugins: {
		ptype       : 'cellediting',
		clicksToEdit: 2,
	}
});