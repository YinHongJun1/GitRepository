package com.mashibing.dp.factorymethod;

public class PlaneFactory {
    public Moveable create(){
        System.out.println(" a new plane created...");
        return  new Plane();};
}
