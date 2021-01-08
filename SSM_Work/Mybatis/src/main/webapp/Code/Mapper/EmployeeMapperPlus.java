package Mapper;

import Bean.Employee;

import java.util.List;

/**
 * @author lenovo
 */
public interface EmployeeMapperPlus {


    public Employee getEmployeeById(Integer id);

    public Employee getEmployeeAndDept(Integer id);

    public Employee getEmployeeAndDeptByStep(Integer id);

//    根据部门查找相关人员,分布查询

    public List<Employee> getEmployeeByDidStep(Integer did);

    public Employee getEmployeeByDidGender(Integer id);
}
