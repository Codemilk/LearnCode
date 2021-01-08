package com.learn.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Person {


    private String name;
    private int age;
    private List<CAR> cars;
    private int money [];
    private Set watch;

    public Person(String name, int age, List<CAR> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

    public Person(){};

    public Set getWatch() {
        return watch;
    }

    public void setWatch(Set watch) {
        this.watch = watch;
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

    public List<CAR> getCars() {
        return cars;
    }

    public void setCars(List<CAR> cars) {
        this.cars = cars;
    }

    public int[] getMoney() {
        return money;
    }

    public void setMoney(int[] money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", money=" + Arrays.toString(money) +
                ", watch=" + watch +
                '}';
    }
}
