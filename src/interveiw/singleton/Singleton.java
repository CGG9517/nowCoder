package interveiw.singleton;

/**
 * @Class: Singleton
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class Singleton {
    private Singleton(){};
    private static Singleton singleton = new Singleton();
    public static Singleton newInstance(){
        return singleton;
    }
}