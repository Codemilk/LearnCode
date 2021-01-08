package itheima;

public class student {


    private String name;
    public String address;
    int age;

    public student(){

    }

    private student(String name){
        this.name=name;
    }

    student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private void function(){
        System.out.println("function");
    }

    public void method1(){
        System.out.println("method1");
    }

    public  void method2(){
        System.out.println("method2");
    }

    public String method3(String s,int i){
        return s+""+i;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
