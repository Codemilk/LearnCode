public class test {

     int i=1;

     class Human{

    }

    class man extends Human{

    }

    class women extends Human{

    }

    public women giveWomen(){
        return new women();
    }

    void sayHello(Human human){
        System.out.println("human");
    }

    void sayHello(man man){
        System.out.println("man");
    }
    void sayHello(women women){
        System.out.println("women");
    }


    public void s(){
        women women = new women();
    }

    public static void main(String[] args) {

        test test=new test();
//        这两种
        Human human = test.new Human();
        Human women = test.giveWomen();
        Human man = test.new man();
        test.sayHello(human);
        test.sayHello(women);
        test.sayHello(man);


    }
}
