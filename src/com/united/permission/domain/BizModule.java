package com.united.permission.domain;

/**
 * Created by turningOwei on 2016/12/22.
 */
public enum BizModule {
    BIZ_GENERAL_MANAGER("biz_general_manager","总经理业务模块"),
    BIZ_BUYER("biz_buyer","采购业务模块"),
    BIZ_DESIGNER("biz_designer","设计业务模块"),
    BIZ_PROJECT("biz_project","项目业务模块"),
    BIZ_FINANCE("biz_finance","财务业务模块");
    private String moduleKey;
    private String moduleName;
    private BizModule(String moduleKey,String moduleName){
        this.moduleKey = moduleKey;
        this.moduleName = moduleName;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public String getModuleName() {
        return moduleName;
    }

}
