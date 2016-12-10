/**
 * @author tangL
 * @date 2014-10-29
 */

App = function() {
    Ext.require([
        'App.Viewport'
    ]);

    var win			 = null;
    view		 = null;

    return {
        init  : function(data) {
            App.initData(data);
        },
        initData  : function(data) {
            Ext.Logger.info('data initializing...');
            if (view == null)
                view = Ext.create('App.Viewport');
            view.initData(data);
        },
        logout  : function() {
            var ysFn = function() {
                ExtUx.Ajax.request({
                    url 	 : SysConfig.ctx + 'loginout.do',
                    succFn	 : function(response, result, opti) {
                        App.reLogin();
                    }
                });
            };
            Msg.ynMsg('��ȷ��Ҫע�����û���?', ysFn);
        },
        login	: function() {
            App.createWin('�û���½');
            win.show();
        },
        reLogin : function() {
            App.createWin('<font color="red">��ǰ�û�ʧЧ, �����µ�½...</font>');
            if (!win.isVisible()) {
                win.getForm().reset();
                win.show();
            }
        },
        posSettle : function() {
            pos_settle();
        },
        posSign : function() {
            pos_signIn();
        }

    };
}();
