package Interface;


interface FatherPocess {
    String name();
    Object pocess(Object o);
}

class  Filter1{
    public String  name(){
        return this.getClass().getSimpleName();
    }

    public String pocess(Object o){
        return ((String)o).toLowerCase();
    }

}

//适配器
class ClassAdapter implements FatherPocess{

    Filter1 filter;

    public ClassAdapter(Filter1 filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public String pocess(Object string) {
        return filter.pocess(string);
    }
}

public class Music {

    public static  String s="hello world";

    static void pocess(FatherPocess d,String s){

        System.out.println(d.pocess(s));

    }

    public static void main(String[] args) {

        pocess( new ClassAdapter(new Filter1()),s);

    }


}


/** 继承复用，多态为根本
 * package Interface;
 *
 * class Father{
 *     public String  name(){ return this.getClass().getSimpleName(); }
 *     public Object pocess(Object o){
 *         return o;
 *     }
 * }
 *
 * class son extends Father{
 *
 * //    这里返回的参数是String，用了协变类型反参
 *     @Override
 * //    toUpperCase():string的方法，大写字符串
 *
 *     public String pocess(Object o) { return ((String)o).toUpperCase(); }
 * }
 *
 *
 * class  fileter{
 *     public String  name(){
 *         return this.getClass().getSimpleName();
 *     }
 *
 *     public String pocess(Object o){
 *         return ((String)o).toLowerCase();
 *     }
 *
 * }
 *
 * class sonProxy extends Father{
 *
 *     fileter first;
 *
 *     public sonProxy(fileter fileter) {
 *         this.first=fileter;
 *     }
 *
 *     @Override
 *     public String name() {
 *
 *         return first.getClass().getName();
 *
 *     }
 *
 *     @Override
 *     public Object pocess(Object o) {
 *         return first.pocess("666");
 *     }
 * }
 * public class Music {
 *
 *     public static  String s="hello world";
 *
 *     public static void pocess(Father father,Object s){
 *         System.out.println(father.name());
 *         System.out.println(father.pocess(s));
 *     }
 *
 *
 *
 * }
 */
