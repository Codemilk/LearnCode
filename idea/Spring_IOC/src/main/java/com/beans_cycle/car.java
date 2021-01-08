package com.beans_cycle;

public class car {



    public car(){
        System.out.println("car的构造器");
    }

   private  String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }

    public void  init(){
        System.out.println("init");
    }

    public void destory(){
        System.out.println("destory");
    }

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
