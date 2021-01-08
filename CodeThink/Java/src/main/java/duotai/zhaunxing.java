package duotai;

class a {

    void b(){
        System.out.println("b");
    }

    void c(){
        System.out.println("c");
    }

}

class a1 extends a{
    void e(){
        System.out.println("c");
    }
    void d(){
        System.out.println("d");
    }

}
public class zhaunxing {

    public static void main(String[] args) {
        a1 d1= (a1) new a();

        d1.e();

    }
}
