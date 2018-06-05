package interveiw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Class: ReflectionUtil
 * @Description: ReflectionUtil.get(dog, "owner.car.engine.id");
 *              可以获得dog对象的主人的汽车的引擎的ID号。
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class ReflectionUtil {
    public ReflectionUtil() {
        throw new AssertionError();
    }
    /**
     * @Description: 通过反射取对象指定字段(属性)的值
     * @param target 目标对象
     * @param fieldName 属性名
     * @return: java.lang.Object
     * @Author: Jiang Chao
     * @Date: 2018/6/5
     * @Version: 1.0
     */
    public static Object getValue(Object target, String fieldName)
    {
        Class<?> clazz = target.getClass();
        String[] fields = fieldName.split("\\.");
        try {
            for (int i = 0; i < fields.length-1; i++ )
            {
                Field field = clazz.getDeclaredField(fields[i]);
                field.setAccessible(true);
                target = field.get(target);
                clazz = target.getClass();
            }

            Field field = clazz.getDeclaredField(fields[fields.length-1]);
            field.setAccessible(true);
            return field.get(target);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void setValue(Object target, String fieldName, Object value)
    {
        Class<?> clazz = target.getClass();
        String[] fields = fieldName.split("\\.");
        try {
            for (int i = 0; i < fields.length-1; i++ )
            {
                Field field = clazz.getDeclaredField(fields[i]);
                field.setAccessible(true);

                Object obj = field.get(target);
                if (obj == null)
                {
                    Constructor<?> cons = field.getType().getConstructor();
                    cons.setAccessible(true);
                    obj = cons.newInstance();
                    field.set(target, obj);
                }

                target = obj;
                clazz = target.getClass();
            }

            Field field = clazz.getDeclaredField(fields[fields.length-1]);
            field.setAccessible(true);
            field.set(target, value);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
