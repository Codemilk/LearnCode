package Bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author lenovo
 */
public class Department implements Serializable {

    private Integer id;
    private String deptName;
    private List<Employee> employeeList;

    public Department(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
