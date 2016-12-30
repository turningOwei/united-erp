Ext.define('Module.account.AddOrEditForm', {
    requires      : ['Module.permission.role.RoleLocalCombobox'],
    xtype         : 'accountaddoreditform',
    extend 		  : 'ExtUx.form.CusForm',
    defaults: {
        anchor: '100%'
    },
    items         :[{
        fieldLabel: '姓名',
        name: 'name',
        allowBlank: false
    },{
        fieldLabel: '手机',
        name: 'mobilePhone',
        allowBlank: false
    },{
        fieldLabel: '电子邮件',
        name: 'email',
        allowBlank: true
    },{
        xtype:'roleremotecombobox',
        fieldLabel: '角色',
        name: 'bizModuleKey',
        rawProp	 : 'roleName',
        allowBlank: false
    },{
        fieldLabel: 'id',
        hidden:true,
        name: 'id',
    },{
        fieldLabel: '公司Id',
        hidden:true,
        name: 'corpId',
    }]
});