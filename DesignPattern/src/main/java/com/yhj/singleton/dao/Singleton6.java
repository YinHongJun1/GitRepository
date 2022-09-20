package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 双重检查
 */
public class Singleton6 {
    private static Singleton6 INSTANCE;

    private Singleton6(){}

    public static Singleton6 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton6();

                }
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton6.getINSTANCE().hashCode());
            }).start();
        }
    }
}
