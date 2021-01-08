package Internal;

interface Des{
    default String say(){
        System.out.println("hehe");
        return "Des";
    }
}
/**方法的内部类*/
public class Internal {

    /**在方法里面的内部类，只有方法方法的作用域可以访问到这个类*/
      public Des getPDes(){
          class PDes implements Des {

              private String label;
              PDes(String label){
                  this.label = label;
              }

              public void readLabel() {
                  System.out.println(label);
              }
          }
          return new PDes("PDes");

      }

}

/**匿名内部类*/
abstract class Base{

    public Base(int x) {
        System.out.println(x);
    }

    public Base() {
    }

    abstract public String readBase();

}
class Utils{

    int o=4;

    public Base getNonameBase(final int a,int x){

        return new Base(x) {



            private int b=a;

            private int b2=o;
            @Override
            public String readBase() {
                return ""+a+"\n"+b2;
            }
        };
    }

//    public Des  getNonameDes(){
//        return new Des() {
//            @Override
//            public String say() {
//                return "InternalDes";
//            }
//        };
//    }

    public static void main(String[] args) {
//        Des nonameDes = new Utils().getNonameDes();
//        System.out.println(nonameDes.say());
        Base nonameBase = new Utils().getNonameBase(1, 1);

        System.out.println(nonameBase.readBase());
    }
}