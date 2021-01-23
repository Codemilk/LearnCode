package springsecurity.Entity;

import lombok.Data;

//Lombok的注解@Data可以通过getter和setter方法
@Data
public class Users {
    private int id;
    private String username;
    private String password;
}
