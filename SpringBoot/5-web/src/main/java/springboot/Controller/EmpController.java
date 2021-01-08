package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.Dao.DepartmentDao;
import springboot.Dao.EmployeeDao;
import springboot.entities.Department;
import springboot.entities.Employee;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @PutMapping(value = "/emp")
    public String edit_saveEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String editEmployee(@PathVariable("id")Integer id,Map map){

        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("emp", employee);
        map.put("depts", departments);
        return "/register";
    }

    @PostMapping("emp")
    public String addEmployee(Employee employee){
         employeeDao.save(employee);

//         去员工页面
         return "redirect:/emps";
    }

   @GetMapping("/emps")
    public String getEmps(Map map){

       Collection<Employee> all = employeeDao.getAll();

       map.put("emps",all);

       return "list";
   }

   @GetMapping("/emp")
    public String toAddPage(Map map){

       //获取所有的部门信息
       Collection<Department> departments = departmentDao.getDepartments();

       map.put("depts", departments);
       return "register";
   }
}
