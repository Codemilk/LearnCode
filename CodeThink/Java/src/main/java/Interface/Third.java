package Interface;

import java.util.Random;

interface WOLF{
    final  int a=1;

//    接口连构造器都没有
    abstract void  Wang();
    abstract  void eat();
}



class dog{
    public void eat() { System.out.println("wangwang"); }
}

class Dog extends dog{
    @Override
    public void eat() {
        System.out.println("WANGWANG"); }}


class Cat {
    public void eat() {
        System.out.println("Miaomiao    "); }}
/**
 * @author lenovo
 */
public class Third extends Cat implements WOLF{

    @Override
    public void Wang() {

    }

    public static void main(String[] args) {
        new Third().eat();
        System.out.println(WOLF.a);

        for(int i=1;i<=3;i++){
        int w = new Random().nextInt(3);
            System.out.println(w);
        }

    }
}
