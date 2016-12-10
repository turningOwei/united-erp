Ext.define('Sos.jni.module.toDeal.ToDealStore', {
    extend: 'Ext.data.Store',

    alias: 'store.toDealStore',

    fields: [
        'toDeal','dealName','memo'
    ],
    proxy: {
        type	: 'ajax',
        autoLoad: true,
        url		: contextPath+'/vdpgRlToDeal/listAll',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});
