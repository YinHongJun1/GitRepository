package com.mashibing.dp.factorymethod.testfactorymethod;

import com.mashibing.dp.factorymethod.Moveable;

public class Android implements Createable {
private  String name = "android";
    @Override
    public void creat() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
