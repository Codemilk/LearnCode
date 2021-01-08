package COM.dao;

import COM.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapperDao {

    public Employee getEmpById(Integer id);

    public boolean addEmpById(Employee employee);

    public boolean updateEmpById(Employee employee);

    public boolean deleteEmpById(Integer id);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastname") String name);

    public Employee getEmpByIdAndLastMap(Map<String ,Object> map);

    public List<Employee> getEmpsByLastName(String lastName);

//    返回一条记录的map：key就是列名，值就是对应的值：
    public  Map<String,Object> getEmpByIdReturnMap(Integer id);

//     返回多条记录的map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
     @MapKey("id")
//    告诉mybaits封装这个map的时候那个属性作为主键
    public Map<Integer,Employee> getEmpsByLastNameReturnMap(String LastName);

}
