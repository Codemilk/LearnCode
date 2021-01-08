package Mapper;

import Bean.Department;

/**
 * @author lenovo
 */
public interface DepartmentMapper {

    public Department getDepartmentById(Integer id);

    /*通过部门表的id找到每个部门的人*/

    public Department getEmployeesByIdPlus(Integer id);

    public Department getDepartmentByIdStep(Integer id);

}
