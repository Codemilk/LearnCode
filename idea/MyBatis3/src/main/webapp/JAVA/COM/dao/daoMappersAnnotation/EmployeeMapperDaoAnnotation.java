package COM.dao.daoMappersAnnotation;

import COM.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperDaoAnnotation {

    @Select("select * from tbl_employee where id = #{id}")
    public Employee getEmpById(Integer id);
}
