package interveiw;

/**
 * @Class: CloneTest
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/1
 */
public class CloneTest {
    public static void main(String[] args) {
        Person p1 = new Person("jiangchao",17, new Car("Ford"));
        try {
            Person p2 = MyUtil.clone(p1);
            p1.getCar().setBrand("BYD");

            System.out.println(p2.getCar());
            System.out.println(p1.getCar());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
