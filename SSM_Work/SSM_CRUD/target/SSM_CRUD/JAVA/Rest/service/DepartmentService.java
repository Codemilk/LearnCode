package Rest.service;

import Rest.bean.Department;
import Rest.dao.DepartmentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDeptAll() {

        return departmentMapper.selectByExample(null);
    }
}
