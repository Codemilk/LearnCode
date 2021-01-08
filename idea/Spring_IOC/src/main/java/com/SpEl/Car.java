package com.SpEl;

public class Car {

    private String brand;

    private double price;

    private  double  tyrePetimeter;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTyrePetimeter() {
        return tyrePetimeter;
    }

    public void setTyrePetimeter(double tyrePetimeter) {
        this.tyrePetimeter = tyrePetimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePetimeter=" + tyrePetimeter +
                '}';
    }
}
