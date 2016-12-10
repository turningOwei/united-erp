Ext.define('Sos.jni.module.toDeal.ToDealComboBox', {
	extend		  : 'Ext.form.field.ComboBox',
	xtype		  : 'toDealComboBox',
	queryMode	  : 'remote',
	fields	   	  : ['toDeal', 'dealName'],
	displayField  : 'dealName',
	valueField	  : 'toDeal',
	editable	  : false,
	params		  : null,
	initComponent : function() {
		this.store = this.buildStore();
		this.callParent();
	},
	buildStore	  : function() {
		var fields 		= this.fields,
		    url   	 	= contextPath+'/vdpgRlToDeal/listAll',
		    me			= this,
		    params      = this.params;

		return Ext.create('Ext.data.Store', {
			fields         : fields,
			proxy				: {
				type			: 'ajax',
				url			:  url,
				actionMethods  : {
					create : 'POST',
					read   : 'POST',
					update : 'POST',
					destroy: 'POST'
				},
				reader			: {
					type		  : 'json',
					rootProperty : 'items'
				}

			},
			listeners     : {
				'beforeload' : me.onStoreBeforeLoadFn,
				scope		 : me
			}
		});
	},
	onStoreBeforeLoadFn : function(store, operation, eOpts) {
		var params = this.params;
		operation.setParams(params);
	},
	onDestroy    : function() {
		this.fields = null;
		this.params = null;
		this.callParent();
	}
});