package com.mashibing.dp.abstractfactory;

/**
 * 抽象工厂-抽象产品
 */
public abstract class AbastractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
