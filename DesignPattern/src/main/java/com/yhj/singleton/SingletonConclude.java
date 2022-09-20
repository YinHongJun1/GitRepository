package com.yhj.singleton;

/**
 * @Auther:yhj
 * @Date:2022/4/25 - 04 - 25 - 17:56
 * @Description: com.yhj.singleton
 * @version: 1.0
 */
public class SingletonConclude {
 /**   // 饿汉式,很好的一种方式，由jvm保证单例，线程安全，但缺点就是不管是否使用它，都会被加载
    private static final SingletonConclude INSTANCE = new SingletonConclude();

    private SingletonConclude(){}

    public static SingletonConclude getInstance(){
        return INSTANCE;
    }

    public void p(){
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        SingletonConclude ins1 = SingletonConclude.getInstance();
        SingletonConclude ins2 = SingletonConclude.getInstance();
        System.out.println(ins1 == ins2);
    }
  **/
/**
    // 初始化实例放入静态代码块中实现
    private static final SingletonConclude INSTANCE;

    static{
        INSTANCE = new SingletonConclude();
    }

    private SingletonConclude(){}

    public static SingletonConclude getInstance(){
        return INSTANCE;
    }

    public void p(){
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        SingletonConclude ins1 = SingletonConclude.getInstance();
        SingletonConclude ins2 = SingletonConclude.getInstance();
        System.out.println(ins1 == ins2);
    }
 **/
/**
// 懒加载，线程不安全
private static SingletonConclude INSTANCE;

    private SingletonConclude(){}

    public static SingletonConclude getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new SingletonConclude();
        }
        return INSTANCE;
    }

    public void p(){
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                System.out.println(SingletonConclude.getInstance().hashCode());
            }).start();
        }
    }
 **/
/**
// 线程安全了，但是效率不够，总是要进行加锁判断
private static SingletonConclude INSTANCE;

    private SingletonConclude(){}

    public static synchronized SingletonConclude getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new SingletonConclude();
        }
        return INSTANCE;
    }

    public void p(){
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                System.out.println(SingletonConclude.getInstance().hashCode());
            }).start();
        }
    }
 **/
/**
// 线程不安全,if判断和synchronized未能一体化操作
private static SingletonConclude INSTANCE;

    private SingletonConclude() {
    }

    public static SingletonConclude getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonConclude.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new SingletonConclude();
            }

        }
            return INSTANCE;
    }

    public void p() {
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(SingletonConclude.getInstance().hashCode());
            }).start();
        }
    }
 **/
/**
// 双重检查，线程安全了且高效
private static SingletonConclude INSTANCE;

    private SingletonConclude() {
    }

    public static SingletonConclude getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonConclude.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new SingletonConclude();

                }
            }

        }
        return INSTANCE;
    }

    public void p() {
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(SingletonConclude.getInstance().hashCode());
            }).start();
        }
    }
**/
/**
    // 匿名内部类的方式
    private SingletonConclude() {
    }

    static class InSingleton{
        private static SingletonConclude INSTANCE = new SingletonConclude();
    }
    public static SingletonConclude getInstance() { return InSingleton.INSTANCE; }

    public void p() {
        System.out.println("开开心心玩耍");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(SingletonConclude.getInstance().hashCode());
            }).start();
        }
    }
 **/
/**
    //最后一种，利用枚举，既保证线程安全，还可以反序列化
    enum Singleton{
        INSTANCE;
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Singleton.INSTANCE.hashCode());
            }).start();
        }
    }

}
 **/

}
