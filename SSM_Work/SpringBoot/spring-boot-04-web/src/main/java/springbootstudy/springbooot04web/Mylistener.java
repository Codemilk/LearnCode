package springbootstudy.springbooot04web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Mylistener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        System.out.println("servletContext销毁完毕");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("servletContext建立完成");
    }
}
