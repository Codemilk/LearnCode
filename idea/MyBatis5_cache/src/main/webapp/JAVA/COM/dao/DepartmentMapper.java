package COM.dao;

import COM.bean.Department;

public interface DepartmentMapper {

    public Department getDeptName(Integer d_id);

    public Department getDeptNamePlus(Integer d_id);

    public Department getDeptByIdStep(Integer id);
}
