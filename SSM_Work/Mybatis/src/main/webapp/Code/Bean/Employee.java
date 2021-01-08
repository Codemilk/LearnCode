package Bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author lenovo
 */

public class Employee implements Serializable {

    public Employee() {
    }

    private Integer id;
    private String lastname;
    private String email;
    private String gender;
    private Department d_id;


    public Employee(Integer id, String lastname, String email, String gender, Department d_id) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.d_id = d_id;
    }

    public Employee(Integer id, String lastname, String email, String gender) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
    }

    public Employee(String lastname, String email, String gender, Department d_id) {
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.d_id = d_id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getD_id() {
        return d_id;
    }

    public void setD_id(Department d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", d_id=" + d_id +
                '}';
    }
}
