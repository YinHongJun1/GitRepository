package com.mashibing.dp.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbastractFactory f = new ModernFactory();
        AbastractFactory f2 = new MagicFactory();

        System.out.println(" 《《现代工厂开始创建》》");
        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();

        System.out.println(" 《《魔法工厂开始创建》》");
        Vehicle c2 = f2.createVehicle();
        c2.go();
        Weapon w2 = f2.createWeapon();
        w2.shoot();
        Food b2 = f2.createFood();
        b2.printName();
    }
}
