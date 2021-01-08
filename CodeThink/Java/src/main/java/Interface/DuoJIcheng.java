package Interface;

interface A{
    void fight();
}

interface B{
    void b();
}

interface C{
    void c();
}

class D {

    public void fight() {
        System.out.println("D fight");
    }
}

class E extends D implements A,B,C{


    @Override
    public void fight() {
        super.fight();
    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}

public class DuoJIcheng {

    public static void main(String[] args) {

        E e=new E();
        e.fight();
    }

}

//**********************************************************************************************************************

//接口相互继承

interface Father{
    void write();
}

interface  son extends Father{

    void play();
}

class grandSon implements son{


    @Override
    public void write() {

    }

    @Override
    public void play() {

    }
}