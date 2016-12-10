/**
 * This view is an example list of people.
 */
Ext.define('Sos.jni.view.main.SmokeSensorPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'smokeSensorPanel',

    requires: [
        'Sos.jni.store.SmokeSensorStore'
    ],

    title: '烟感传感器信息',

    store: {
        type: 'smokesensor'
    },
    
    columns: [
        { text: '名称', 				dataIndex: 'name', 			width:120 },
        { text: '状态(报警/正常)', 	dataIndex: 'isAlarm', 		width:200,	
        	renderer:function(value, record){
	    		if(value == true){
	    			var au = document.createElement("audio");
		    		au.preload="auto";
		    		au.src = contextPath+"/static/resources/sound/ALARM1.WAV";
		    		
		    		au.addEventListener('ended', function () { 
		    			setTimeout(function () {au.play();}, 500); 
		    			}, false); 
		    		au.play();
		    		var result = '<font size="3" color="red">报警</font>';
		    		return result;
	    		}
	    		return '正常';
	    	}
        },
        { text: '物理地址', 			dataIndex: 'position', 		flex: 1 },
        { text: '节点ID', 			dataIndex: 'nodeId',		flex: 1}
    ],

    listeners: {
        select: 'onItemSelected',
        /*rowclick : function( thiz , record , tr , rowIndex , e , eOpts){
        	console.log(this.getStore());
        },*/
        afterlayout :function( thiz , layout , eOpts ) {
        	//console.log(this.getStore());
        }
    }
});
