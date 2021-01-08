package duotai;

/**
 * @author lenovo
 */

class Father{


    void Draw(){
        System.out.println("fatherDraw");
    }

    Father(){

        System.out.println("father");
        Draw();
    }
}

class Son extends Father{

    private int r=1;
    @Override
    void Draw(){
        System.out.println("SonDraw "+r);
    }

    Son(int r) {
        this.r = r;
        System.out.println("Son "+r);
    }
}
public class Constroctor {

    public static void main(String[] args) {

        Son son=new Son(2);


    }
}
