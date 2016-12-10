/**
 * 定义extjs 模块加载路径
 * Ext.require('XX.fileName') // 模块代表配置的路径 路径会把.解析成/ 路径最有就会变为XX/fileName
 * 如果在Ext.Loader.setConfig 配置了对应的path那么,XX会解析成对应的path/fileName
 *
 */
Ext.Loader.setConfig({
    paths : {
        ExtUx    : SysConfig.jsPath + '/extux', // 系统扩展包
        App      : SysConfig.jsPath + '/app', // app模块路径
        Sys      : SysConfig.jsPath + '/sys', // 系统模块
        Subject  : SysConfig.jsPath + '/subject'
    }
});