Ext.define('Sos.jni.module.timeIntvl.TimeIntvlStore', {
    extend: 'Ext.data.Store',

    alias: 'store.timeIntvlStore',

    fields: [
        'createDate','description','endTimeIntvl','id',
        'isForceCorrect','maxVal','memo','minVal','numTime',
        'ruleId','startTimeIntvl','toDeal','updateDate'
    ],
    proxy: {
        type	: 'ajax',
        autoLoad: true,
        url		: contextPath+'/rlTimeIntvl/selectTimeIntervalByRuleId',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});
