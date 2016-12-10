Ext.define('Sos.jni.module.timeIntvl.TimeIntvlPanel', {
	extend: 'Ext.grid.Panel',
	xtype : 'timeIntvlPanel',
	requires: [
		'Sos.jni.module.timeIntvl.TimeIntvlStore',
		'Sos.jni.module.toDeal.ToDealComboBox',
		'ExtUx.form.combobox.LocalComboBox'
	],
	initComponent : function() {
		this.callParent();
	},
	title: '日时段详细规则',
	ruleId : null,

	store  : {
		type: 'timeIntvlStore'
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
		{xtype: 'button', text: '添加',
			listeners: {
				'click': function(thiz,e,eOpts){
					var thisPanel = thiz.ownerCt.ownerCt;
					thisPanel.getStore().insert(0,{
						ruleId : thisPanel.ruleId
					});
				}
			}},
		{xtype: 'button', text: '保存',listeners:{
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
					url     : contextPath+'/rlTimeIntvl/saveModifed',
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
		}},
		{xtype: 'button', text: '删除',
			listeners: {
				'click': function(thiz,e,eOpts){
					var thisPanel = thiz.ownerCt.ownerCt,
						models = thisPanel.getSelection();
					if(models.length == 0){
						return Ext.MessageBox.alert('信息','未选择!');
					}
					var ids = [];
					for(var index in models){
						var model =  models[index];
						if(!model.phantom){
							var    id  = models[index].get('id');
							ids.push(id);
						}

					}
					var params = {
						ids  : ids,
					};
					Ext.Ajax.request({
						url     : contextPath+'/rlTimeIntvl/deleteByIds',
						params  : params,
						success : function(response, opts) {
							Ext.MessageBox.alert('信息','删除成功!');
							thisPanel.getStore().reload();
						},

						failure: function(response, opts) {
							Ext.MessageBox.alert('信息','删除失败!');
							console.log('server-side failure with status code ' + response.status);
						}
					});
				}
			}
		}
	],
	selModel: {
		selType :   'checkboxmodel',
		mode    :   'MULTI'
	},

	columns: [
		{text: '开始时段',		dataIndex: 'startTimeIntvl', 	width: 100,
			editor      : {
				xtype     : 'timefield',
				format    : 'H:i:s'
			}
		},
		{text: '结束时段',      dataIndex: 'endTimeIntvl',   	width: 100,
			editor      : {
				xtype     : 'timefield',
				format    : 'H:i:s'
			}
		},
		{text: '是否<br>强制矫正',	dataIndex: 'isForceCorrect',	width: 80,
				editor      : {
					xtype     : 'extuxlocalcombobox',
					cData     :[[0,'否'],[1,'是']]
				}
		},
		{text: '起始数值',      dataIndex: 'minVal',   			width: 100,
			editor      : {
				xtype     : 'numberfield',
					minValue  : 1
			}
		},
		{text: '结束数值',		dataIndex: 'maxVal',			width: 100},
		{text: '变更次数',		dataIndex: 'numTime',			width: 100,
					editor      : {
						xtype     : 'numberfield',
						minValue  : 1
					}
		},
		{text: '处理方式',      dataIndex: 'toDeal',   			width: 150,
				editor      : {	xtype     : 'toDealComboBox'}
		},
		{text: '描述',			dataIndex: 'description',		width: 300},
		{text: '备注',      	dataIndex: 'memo',   			width: 150},
		{text: '创建时间',      dataIndex: 'createDate',   		width: 150},
		{text: '修改时间',		dataIndex: 'updateDate',		width: 300}
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
		listeners   : {
			'edit': function (editor, e) {
				var field = e.field,
				    record= e.record,
				    timeStr = record.get(field),
				    startTime = new Ext.form.field.Time({
					    format: 'H:i:s'
				    }),
				    endTime   = new Ext.form.field.Time({
					    format: 'H:i:s'
				    }),
				    dateStr = Ext.Date.format(new Date(), 'Y-m-d');

				if(field == 'startTimeIntvl' || field == 'endTimeIntvl'){
					var time = new Ext.form.field.Time({
						format: 'H:i:s'
					});
					time.setValue(timeStr);
					record.set(field,time.getRawValue());
				}

				var endTimeStr = record.get('endTimeIntvl'),
				    startTimeStr = record.get('startTimeIntvl');
				endTime.setRawValue(endTimeStr);
				startTime.setRawValue(startTimeStr);
				if(startTime.getValue().getTime() > endTime.getValue().getTime()){
						record.set(field,record.getModified(field));
				}

			}
		}
	}
});