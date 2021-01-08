package com.bean_factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {



    private Map <String,Car> cars=null;

    public InstanceCarFactory(){
        cars=new HashMap<String,Car>();
        cars.put("audi", new Car("audi",3000000));
        cars.put("ford", new Car("ford",3000000));

    }


    public Car getCar(String name){

        return cars.get(name);
    }

}
