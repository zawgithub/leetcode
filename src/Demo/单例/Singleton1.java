package Demo.单例;

/**
 * 双重校验锁
 * @Author: zhaoanwei
 * @Date: 2020/9/21
 */
public class Singleton1 {
    private volatile static Singleton1 singleton1;

    private Singleton1(){};

    public static Singleton1 getInstance(){
        if (singleton1==null){
            synchronized (Singleton1.class){
                if (singleton1==null){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
