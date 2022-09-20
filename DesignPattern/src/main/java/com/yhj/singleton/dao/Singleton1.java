package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 22:48
 * @Description: com.yhj.singleton
 * @version: 1.0
 * 饿汉式
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){};

    public static Singleton1 getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        // 拿到的实例是同一个
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton2);
    }

}
