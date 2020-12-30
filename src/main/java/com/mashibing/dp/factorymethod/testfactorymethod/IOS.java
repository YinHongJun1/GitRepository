package com.mashibing.dp.factorymethod.testfactorymethod;

public class IOS implements Createable{
 public String name = "ios";
    @Override
    public void creat() {
        System.out.println("创建成功！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
