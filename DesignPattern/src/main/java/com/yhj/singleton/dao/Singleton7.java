package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 静态内部类方式
 */
public class Singleton7 {

    private Singleton7(){}

    private static class InSingleton7{
        private  final static Singleton7 INSTANCE = new Singleton7();
    }
    // 调用getInstance方法才会去加载内部类对象
    public static Singleton7 getInstance() {
        return InSingleton7.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton7.getInstance().hashCode());
            }).start();
        }
    }
}
