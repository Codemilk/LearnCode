package duotai;

class instrument{

    private int a=2;

    static void p1(){
        System.out.println("duotai.instrument Static");
    }

    final void p(){
        System.out.println("instrumentFinal");
    }

    instrument(){
            System.out.println("instrument构造器");

    }
    public void play(){
        System.out.println("instrument ");
    }

    public void instrumentplay(){
        System.out.println("ins"+ ++a);
    }
}

class wind extends  instrument{

    static void p1(){
        System.out.println("wind Static");
    }

    public wind() {
        System.out.println(this);
        System.out.println("wind构造器");
    }

    public void windPlay(){
        System.out.println("windPlay");
    }

    @Override
    public void play(){
        System.out.println("Wind");
    }
}
public class music {

    public static void tune(instrument instrument) {
        instrument.play();
    }

    //这里可以知道 java类型的多态

    public static void main(String[] args) {
        instrument w = new wind();

        w.instrumentplay();


//        final方法通过父类继承而来，但是不可以覆盖，子类调用，但也是父类的final成员
//        w.p();
////        static被隐藏了，但他还是父类的成员
//        wind.p1();
//        tune(w);
    }
}
