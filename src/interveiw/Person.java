package interveiw;

import java.io.Serializable;

/**
 * @Class: Person
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/1
 */
class Person implements Serializable {
    private static final long serialVersionUID = 921326138000577406L;

    private String name;    // 姓名
    private int age;        // 年龄
    private Car car;        // 座驾


    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", car=" + car +
                ", name='" + name + '\'' +
                '}';
    }
}
