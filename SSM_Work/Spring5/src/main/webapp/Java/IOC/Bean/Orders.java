package IOC.Bean;

public class Orders {

    public  Orders(){
        System.out.println("第一步 通过构造器创建对象");
    }

    private String oName;

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        System.out.println("第二步 通过set方法赋值并且引用外部bean");
        this.oName = oName;
    }
    //初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化方法");
    }
    //销毁方法
    public void destoryMethod(){
        System.out.println("第五步 执行销毁方法");
    }
}
