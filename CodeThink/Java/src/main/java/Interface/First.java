package Interface;


abstract class Instrument{
//    抽象方法
    abstract protected void play();

    public void Name(){

        System.out.println(this.getClass().getSimpleName());
    }

}

class Wind extends Instrument{

    //必须实现抽象方法，本身抽象方法是用来操控子类的接口

    @Override
    protected void play() {

        System.out.println("wind");
    }
}


public class First {

    public static void main(String[] args) {
        Instrument i=new Wind();
        i.play();
        i.Name();
    }

}

