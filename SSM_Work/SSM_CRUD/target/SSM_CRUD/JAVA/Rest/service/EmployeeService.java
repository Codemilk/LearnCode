package Rest.service;

import Rest.bean.Department;
import Rest.bean.Employee;
import Rest.bean.EmployeeExample;
import Rest.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> getAll() {
        //注意：这不是一个分页查询
        return employeeMapper.selectByExampleWithDept(null);

    }


    public void save(Employee employee) {

        employeeMapper.insertSelective(employee);

    }

    public boolean checkUser(String empName) {

        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.countByExample(example) == 0;

    }

    public Employee getEmp(Integer id) {

        return employeeMapper.selectByPrimaryKeyWithDept(id);
    }

    public Integer ModifyEmp(Employee employee) {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        return i;
    }

    public Integer deleteEmp(Integer id) {

        return employeeMapper.deleteByPrimaryKey(id);

    }

    public Integer deleteBatchEmp(List<Integer> ids) {
//       自定义例子类，定义mybatis查询条件
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
       criteria.andEmpIdIn(ids);
        Integer i = employeeMapper.deleteByExample(example);
        return i;

    }
}

