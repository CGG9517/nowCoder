package interveiw.singleton;

/**
 * @Class: Singleton
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){};
    public static Singleton newInstance(){
        /*
         * 双重锁检验
         */
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
