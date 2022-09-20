package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 代码块上加把锁
 */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5(){}

    public static Singleton5 getINSTANCE() {
        if(INSTANCE == null){
            synchronized (Singleton5.class){
            try{
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            INSTANCE = new Singleton5();

            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton5.getINSTANCE().hashCode());
            }).start();
        }
    }
}
