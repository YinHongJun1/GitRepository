package com.mashibing.dp.abstractfactory;

/**
 * 具体工厂-具体产品
 */
public class ModernFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
