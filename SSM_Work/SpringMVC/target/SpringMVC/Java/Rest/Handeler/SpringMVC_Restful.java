package Rest.Handeler;


import Rest.Bean.Department;
import Rest.Bean.Employee;
import Rest.Dao.DepartmentDao;
import Rest.Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/Rest")
public class SpringMVC_Restful {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    public String list(Map<String,Object> map){
         map.put("emps", employeeDao.getAll())  ;
        return "List";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String ADD_INPUT(Map<String,Object> map){

        map.put("depts",departmentDao.getDepartments());

        return "add";
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Employee testJson(String reqbody){

         System.out.println("RequestBody："+reqbody.toString());
         return new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA"));
    }


    @RequestMapping("/testJson2")
    public String testJson2(@RequestBody String reqbody){

        System.out.println("RequestBody："+reqbody.toString());
        return "success";

    }

    @RequestMapping("/CommonsMultipartResolver")
    public String CommonsMultipartResolver(@RequestParam("file")MultipartFile multipartFile,@RequestParam("desc") String desc) throws IOException {

        System.out.println(desc);
        System.out.println(multipartFile.getInputStream()+" from "+multipartFile.getName());

        return "success";
    }

}
