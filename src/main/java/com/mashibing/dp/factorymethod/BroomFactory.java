package com.mashibing.dp.factorymethod;

public class BroomFactory {
    public Moveable create() {
        System.out.println("a Broom created!"); // 简单日志
        return new Car();
    }
}
