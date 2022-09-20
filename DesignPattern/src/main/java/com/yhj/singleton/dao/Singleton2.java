package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:03
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE;
    // 静态代码块中进行实例化
    static { INSTANCE = new Singleton2();}


    private Singleton2(){};

    public static Singleton2 getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        // 拿到的实例是同一个
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
