package springbootinitializerquick.springbootinitializer.Bean;

public class Son {

    private String s_name;
    private Integer age;


    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Son{" +
                "s_name='" + s_name + '\'' +
                ", age=" + age +
                '}';
    }
}