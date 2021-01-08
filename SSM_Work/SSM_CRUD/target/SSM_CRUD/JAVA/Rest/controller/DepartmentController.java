package Rest.controller;

import Rest.bean.Department;
import Rest.bean.Employee;
import Rest.bean.Msg;
import Rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDeptsWithJson(){

        List<Department> departments=departmentService.getDeptAll();


        return Msg.Success().add("depts",departments);
    }


}
