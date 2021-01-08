package Mapper;

import Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 */
public interface Dynamic_SQL {

//    携带那个字段，补充哪一个值

    public List<Employee> getEmpByConditionIf(Employee employee);

    public List<Employee> getEmpByConditionTrim(Employee employee);

    public List<Employee> getEmpByConditionChoose(Employee employee);

    public  void updateEmployee(Employee employee);

    public List<Employee> getEmpByConditionForeach(List list);

    public List<Employee> getEmpByConditionForeachMap(@Param("map") Map list);

    //    批量插入

    public void insertEmployeeForeach(List list);


    //   内置参数

    public Employee getEmployeeByInnerParam(Integer id,String s);

    //    bind

    public Employee getEmployeeByBind(String s1,int d);

    //重用sql

    public Employee getEmployeeByRepeatSql(Integer id);
}
