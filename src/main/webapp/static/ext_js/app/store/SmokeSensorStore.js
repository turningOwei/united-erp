Ext.define('Sos.jni.store.SmokeSensorStore', {
    extend: 'Ext.data.Store',

    alias: 'store.smokesensor',

    fields: [	
      'nodeId','name','position','isAlarm'
    ],
    data : {},
    //model: 'Sos.jni.model.DeviceModel',
    proxy: {
        type	: 'ajax',
        autoLoad: true,
        url		: contextPath+'/smokesensor/smokeSensorInfo',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});
