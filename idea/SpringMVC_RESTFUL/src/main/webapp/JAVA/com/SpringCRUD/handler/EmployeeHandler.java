package com.SpringCRUD.handler;

import com.SpringCRUD.Dao.Department;
import com.SpringCRUD.Dao.Employee;
import com.SpringCRUD.DaoImpl.DepartmentDao;
import com.SpringCRUD.DaoImpl.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;


@Controller
public class EmployeeHandler {
    private  static final String SUCCESS="list";

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping(value = "/emps")
    public String list(Map<String, Object> map){

       map.put("employees", employeeDao.getAll());

        return "list";
    }

    @RequestMapping(value = "/emp", method =RequestMethod.GET)
    public String addEmp(Map<String ,Object> map){

        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());

        return "add";
    }

    @RequestMapping(value = "/emp", method =RequestMethod.POST)
    public String Save(@Valid Employee employee, BindingResult bindingResult,Map map
    ){

        System.out.println("save:"+employee);

        if(bindingResult.getErrorCount()>0){

            for(FieldError fieldError:bindingResult.getFieldErrors()){
                System.out.println(fieldError.getField()+":"+fieldError.getDefaultMessage());
            }
            //若验证出错，则转向定制的页面

            map.put("departments", departmentDao.getDepartments());

            return "add";
        }
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){

        employeeDao.delete(id);

        return "redirect:/emps";
    }


    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getUpdate(@PathVariable("id") Integer id,Map<String,Object> map){

        Employee employee = employeeDao.get(id);

        Collection<Department> departments = departmentDao.getDepartments();

        map.put("employee",employee);
        map.put("departments", departments);


        return "add" ;
    }

    @ModelAttribute
    public void lastNameUnChange(@RequestParam(value = "id",required = false) Integer id,Map map) {


        if (id != null) {

            map.put("employee",employeeDao.get(id));

        }else{

        }
    }


    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String Update(Employee employee){
          employeeDao.save(employee);

        return "redirect:emps";
    }


//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//
//        webDataBinder.setDisallowedFields("lastName");
//    }
}
