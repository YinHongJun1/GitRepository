package com.mashibing.dp.factorymethod.testfactorymethod;

import com.mashibing.dp.factorymethod.Car;
import com.mashibing.dp.factorymethod.Moveable;

public class AppleStoreFactory {
    public Createable create() {
        System.out.println("投放进入iOS市场"); // 简单日志
        return new IOS();
    }
}
