package COM.dao;

import COM.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

//    测试if
    //携带哪个字段查询条件就带上这个字段的值
    public List<Employee> getEmpByConditionIf(Employee employee);

//    测试trim
    public List<Employee> getEmpByConditionTrim(Employee employee);

//   测试choose
//     如果带id 就用id查
     public List<Employee> getEmpByConditionChoose(Employee employee);

//set的使用
     public void updateEmp(Employee employee);
//foreach的使用
     public List<Employee> getEmpsByConditionForeach(List<Integer> ids);
//通过foreach的使用，来批量保存
    public void addEmpsByForeach(@Param("emps") List<Employee> emps);
//参数测试
    public List<Employee> getEmpTestPara(Employee  employee);
//测试Bind
    public List<Employee> getEmpTestBind(Employee  employee);

}
