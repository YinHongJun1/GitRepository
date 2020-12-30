package com.mashibing.dp.factorymethod;

/**
 * 简单工厂的可扩展性不好-每次生产一种产品就要加一个new方法
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        //before processing
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
