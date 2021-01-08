package userdao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class userdao {
    private String name;
    private int age;
    private Date birthday;

    public userdao(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public userdao() {

    }

    public String getBitStr(){
        //1.格式化日期对象

    if(birthday!=null){
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd:HH:ss");
        return sdf.format(birthday);
    }else {
        return null;
    }
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
