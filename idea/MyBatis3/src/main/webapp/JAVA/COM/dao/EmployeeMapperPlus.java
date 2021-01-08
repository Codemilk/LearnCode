package COM.dao;

import COM.bean.Department;
import COM.bean.Employee;

import java.util.List;

public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByStep(Integer id);

    public List<Employee> getDeptByIdStep(Integer id);

    public Employee getDeptByIdDiscriminator(Integer id);


}
