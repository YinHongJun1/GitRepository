package com.mashibing.dp.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable m1 = new CarFactory().create();
        Moveable m2 = new PlaneFactory().create();
        Moveable m3 = new BroomFactory().create();
        m1.go();
        m2.go();
        m3.go();
    }
}
