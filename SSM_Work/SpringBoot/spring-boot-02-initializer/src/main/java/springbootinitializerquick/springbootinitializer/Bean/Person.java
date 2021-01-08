package springbootinitializerquick.springbootinitializer.Bean;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置文件进行绑定
 *       1. prefix=“person”：配置文件中指定person下面的属性一一对应,且一定要小写
 *       2. 只有这个组件是容器中的组件，才能提供@ConfigurationProperties功能，所以需要加入@Component
 *       3. 默认是从全局配置文件中获取值
 */

@Component
//prefix一定要小写
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:person.properties")
/**JSR303校验*/
@Validated
public class Person {
//    @Value属性赋值

//    @Value("${person.last-name}")

    private String lastName;
    private Integer age;
    private boolean isPropose;
    private Son son;
    private List<String> pets;
    private Map<String,String> PersonMessage;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isPropose() {
        return isPropose;
    }

    public void setPropose(boolean propose) {
        isPropose = propose;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public List getPets() {
        return pets;
    }

    public void setPets(List pets) {
        this.pets = pets;
    }

    public Map<String, String> getPersonMessage() {
        return PersonMessage;
    }

    public void setPersonMessage(Map<String, String> personMessage) {
        PersonMessage = personMessage;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isPropose=" + isPropose +
                ", son=" + son +
                ", pets=" + pets +
                ", PersonMessage=" + PersonMessage +
                '}';
    }
}
