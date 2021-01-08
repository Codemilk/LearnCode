package com.learn;

import com.sun.media.sound.SoftTuning;

/**
 * Hello world!
 *
 */
public class App 
{

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {
//        System.out.println("setName:" + name);
        this.name = name;
    }
    public void hello(){
        System.out.println("hello:"+name);
    }
    public App(){
        System.out.println("hello world Constructor");
    }

}
