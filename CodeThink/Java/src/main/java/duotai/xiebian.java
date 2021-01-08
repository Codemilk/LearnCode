package duotai;

class A{

    @Override
    public String toString() {
        return "A{}";
    }
}

class A2 extends A{

    @Override
    public String toString() {
        return "A2{}";
    }
}

class B{
    A say(){
       return new A();
    }
}

class B2{
    A2 say(){
        return new A2();
    }
}
public class xiebian {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.say());
        B2 b2 = new B2();
        System.out.println(b2.say());
    }
}
