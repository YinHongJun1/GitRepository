package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 枚举
 */
public enum Singleton8 {

    INSTANCE;


    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton8.INSTANCE.hashCode());
            }).start();
        }
    }
}
