package Mapper;

import Bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 */
public interface EmployeeMapper {

   public void addEmployee(Employee employee);

   public void deleteEmployee(Integer id);

   public void updateEmployee(Employee employee);

   public Employee getEmployee(Integer id);

   public Employee getEmployeeByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);

   public Employee getEmployeeByMap(Map map);

   public List<Employee> getEmployee_List(String string);
/*单个记录*/
   public Map<String,Object> getEmployeeMap(Integer id);

/*多个记录*/

   @MapKey("id")
   //告诉mybatis封装这个map的时候用哪个属性

   public Map<Integer,Employee> getEmployee_Maps(String lastName);
}
