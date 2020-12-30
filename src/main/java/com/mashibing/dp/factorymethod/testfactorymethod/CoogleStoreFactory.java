package com.mashibing.dp.factorymethod.testfactorymethod;

public class CoogleStoreFactory {
    public Createable create() {
        System.out.println(" 投放进入安卓市场 "); // 简单日志
        return new Android();
    }
}
