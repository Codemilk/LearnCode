package springboot.Bean;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;



//@PropertySource("classpath:person.properties")
@Component
/**
 * 将我们的配置文件的每一个属性的值,映射到组件中
 * @ConfigurationProperties:告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *      注意：prefix不可以是大写
 *     只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 * @configurationProperties默认从全局配置文件中获取值获取值
 * */
@ConfigurationProperties(prefix = "person")
//@Validated
public class person {

//    @Value("${person.name}")
//    @Nullable
    private String name;

//    @Value("#{11*22}")
    private int age;
//    @Value("true")
    private boolean isMan;

    private Date birth;
//    @Value("person.maps")
    private Map<String,Object> maps;
    private List<String> list;
    private Dog dog;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMan=" + isMan +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
