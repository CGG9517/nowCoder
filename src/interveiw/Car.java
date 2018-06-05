package interveiw;

import java.io.Serializable;

/**
 * @Class: Car
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/1
 */
class Car implements Serializable {
    private static final long serialVersionUID = -8824620907413727478L;

    private String brand;       // 品牌
    private int maxSpeed;       // 最高时速

    public Car(String brand) {
        this.brand = brand;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
