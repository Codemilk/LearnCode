package com.learn.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person2 {

    private String name;
    private int age;
    private  Map cars;

    public Person2(String name, int age, Map<String, CAR> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }
    public Person2(){};

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

    public Map<String, CAR> getCars() {
        return cars;
    }

    public void setCars(Map<String, CAR> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
