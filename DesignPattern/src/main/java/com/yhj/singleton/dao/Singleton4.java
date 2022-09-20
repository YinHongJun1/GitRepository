package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 在方法上加把锁
 */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4(){}

    public static synchronized Singleton4 getINSTANCE() {
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton4.getINSTANCE().hashCode());
            }).start();
        }
    }
}
