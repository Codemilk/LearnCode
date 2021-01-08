package Internal;

/**
 * @author lenovo
 * 连接到外部类
 */
class CiteinternalClass{

    CiteinternalClass(int i){
        System.out.println("CiteinternalClass构造器："+i);
    }

    void say(int i){
        System.out.println("CiteinternalClass成员方法"+i);
    }
}

class LinkExternal {

    private int i;

    /**组合的引用类*/

    CiteinternalClass internalClass;

    class internalClass{

        internalClass(int i){
            System.out.println("internalClass构造器："+i);
        }
    }

    public LinkExternal(int i) {
        this.i = i;

    }

    public  void link(){
        //引用类创建对象
        internalClass=new CiteinternalClass(i);
        //引用类
        internalClass.say(i);
        //内部类
        new internalClass(i);
    }

    public static void main(String[] args) {
        new LinkExternal(1).link();

    }

}
