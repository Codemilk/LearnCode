package IOC.Bean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Book> {

    //定义返回的bean
    @Override
    public Book getObject() throws Exception {
       Book b= new Book();
       b.setName("abv");
        return b;
    }
    //bean的类型
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //作用域是否是单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
