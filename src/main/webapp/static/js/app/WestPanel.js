/**
 * @author tangL
 * @date 2014-10-29
 */
Ext.define('App.WestPanel', {
    extend 		: 'Ext.tree.Panel',
	xtype  		: 'appwestpanel',
	rootVisible : false,
    initComponent : function() {
    	this.on('itemclick', function(view, record, item, index, e, eOpts) {
			this.fireEvent('nodeClick', this, view, record);
		});
    	this.callParent();
    },
    loadData      : function(data) {
    	this.getRootNode().removeAll();
    	this.getRootNode().appendChild(data);
    }/*,
    createTree  : function(o) {
    	return Ext.create('Ext.TreePanel',{
    		title       : o.text,
    		rootVisible : false,
    		root        : {
    			children : o.children
    		},
    		listeners   : {
    			'itemclick' : function(view, record, item, index, e, eOpts) {
    				this.fireEvent('nodeClick', this, view, record);
    			},
    			scope       : this
    		}
    	});
    }*/
});
