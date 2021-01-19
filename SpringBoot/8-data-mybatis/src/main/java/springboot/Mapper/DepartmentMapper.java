package springboot.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springboot.Bean.department;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id =#{id}")
    public department getDepartment(Integer id);
    
}
