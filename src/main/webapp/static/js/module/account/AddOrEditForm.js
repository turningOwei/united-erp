Ext.define('Module.account.AddOrEditForm', {
    requires      : ['Module.permission.role.RoleLocalCombobox','Module.corp.Department'],
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
        xtype     :'corpdeptcombobox',
        fieldLabel: '部门',
        name      : 'deptId',
        rawProp	  : 'departmentName',
        allowBlank: false
    },{
        xtype       : 'roleremotecombobox',
        fieldLabel  : '角色',
        name        : 'deptRoleId',
        rawProp	    : 'roleName',
        allowBlank  :  false
    },{
        fieldLabel: 'pwd',
        hidden:true,
        name: 'pwd',
    },{
        fieldLabel: 'oid',
        hidden:true,
        name: 'oid',
    },{
        fieldLabel: '公司Id',
        hidden:true,
        name: 'corpId',
    }]
});