package com.mashibing.dp.factorymethod;

public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!"); // 简单日志
        return new Car();
    }
}
