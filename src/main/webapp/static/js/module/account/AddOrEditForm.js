Ext.define('Module.account.AddOrEditForm', {
    //requires      : ['ExtUx.window.SaveOnCloseWin'],
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
        allowBlank: false
    },{
        fieldLabel: 'bizModuleKey',
        hidden:true,
        name: 'bizModuleKey',
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