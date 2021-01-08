package Spring_COM.Beans;

public class testBean {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


    public void test(){
        System.out.println("测试成功"+a);
    }
    @Override
    public String toString() {
        return "testBean{" +
                "a=" + a +
                '}';
    }
}
