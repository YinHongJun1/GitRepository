package com.yhj.singleton.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 23:04
 * @Description: com.yhj.singleton.dao
 * @version: 1.0
 */

/**
 * 懒汉式:线程不安全了
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;
    private Singleton3(){}
    public static Singleton3 getINSTANCE() {
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            // lambda表达式对匿名内部类的简化
            new Thread(()->{
                System.out.println(Singleton3.getINSTANCE().hashCode());
            }).start();
        }
    }
}
