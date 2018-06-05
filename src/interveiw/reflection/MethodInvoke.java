package interveiw.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Class: MethodInvoke
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class MethodInvoke {
    public static void main(String[] args) {
        try {
            String str = "hello";
            Method method = str.getClass().getMethod("toUpperCase");
            String s = (String) method.invoke(str);

            System.out.println(s);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
