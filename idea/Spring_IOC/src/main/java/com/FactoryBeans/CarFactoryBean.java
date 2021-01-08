package com.FactoryBeans;

import com.bean_factory.Car;

import org.springframework.beans.factory.FactoryBean;
//自定义的FactoryBean需要实现FactoryBean 接口
public class CarFactoryBean implements FactoryBean {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回bean的对象
    @Override
    public Object getObject() throws Exception {



        return new Car(brand,555);
    }

    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
