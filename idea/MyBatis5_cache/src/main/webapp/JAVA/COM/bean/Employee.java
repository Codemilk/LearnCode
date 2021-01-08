package COM.bean;

import java.io.Serializable;

//@Alias("emp")
public class Employee implements Serializable {
    private Integer id;
    private String lastname;
    private  String gender;
    private String email;
    private Integer did;
    private Department dept;

    public Employee(Integer id, String lastname, String gender, String email, Integer did) {
        this.id = id;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.did = did;
    }

    public Employee(Integer id, String lastname, String gender, String email, Department dept) {
        this.id = id;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
    }

    public Employee(Integer id, String lastname, String gender, String email) {
        this.id = id;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
    }
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}
