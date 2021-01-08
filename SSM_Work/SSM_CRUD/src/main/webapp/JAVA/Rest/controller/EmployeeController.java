package Rest.controller;

import Rest.bean.Employee;
import Rest.bean.Msg;
import Rest.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
        查询员工
     */
//    @RequestMapping("/emps")
//    public String getEmp(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
//
//            //        分页查询
//            //表示当前页码，以及每页的数据
//            PageHelper.startPage(pn,5);
//            //在这个方法后紧跟着查询
//            List<Employee> emps=employeeService.getAll();
//
//            //PageInfo会包装结果，只需要将pageInfo交给页面就行，它封装了详细的数据
//            PageInfo page=new PageInfo(emps, 5);
//
//
//        model.addAttribute("pageInfo", page);
//        return "list";
//    }

//    创建新的方法，返回json字符串的方法
    @ResponseBody
    //可以自动将数据转化为json字符串，返回给浏览器
    @RequestMapping("/emps")
    public Msg  getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);
        List<Employee> all = employeeService.getAll();

        PageInfo pageInfo = new PageInfo(all, 5);

        return Msg.Success().add("pageInfo",pageInfo);
    }


    //    保存emp
    /*定义Rest风格
           查询： GET /emp/{id}
           保存： POST /emp
           修改:  PUT /emp/{id}
           删除:  DELETE /emp/{id}
     */
    @ResponseBody
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
/*前端校验并不是完全安全，需要jsr303来进行校验
   员工保存：
        1.支持JSR303校验
        2.导入hibernate-validator
      步骤：
        1.加入jar包
        2.在指定类加入注解修饰
        3.使用@valid修饰指定类，在写参数BindingResult

 */
    public Msg saveEmp(@Valid Employee employee, BindingResult bindingResult){

        System.out.println("访问到了");

            if(bindingResult.hasErrors()){

                //表示后端校验失败，在模态框中显示信息
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                for(FieldError e:fieldErrors){
                    System.out.println("错误字段名"+e.getField());
                    System.out.println("错误信息"+e.getDefaultMessage());
                }
                return Msg.fail().add("fieldErrors",fieldErrors);

            }else {
                //表示没错
                employeeService.save(employee);

                return Msg.Success();
            }


    }

    //检查信息是否重复
    @ResponseBody
    @RequestMapping("/checkUser")
    public Msg checkUser(@RequestParam("empName") String empName){
        //为了保证是否是合法的表达式

            String regx="(^[A-Za-z0-9]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";

        if(!empName.matches(regx)){
            return Msg.fail().add("Valid_msg", "名字必须是2-5个中文或者6-16位英文数字组合");
        }


            //返回true确定没有重复的
           boolean b= employeeService.checkUser(empName);

       return b==true?Msg.Success():Msg.fail().add("Valid_msg","用户名重复");
    }

    //查询个人信息
    @RequestMapping(value = "/getEmp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){

//        System.out.println("getEmp");
        Employee emp = employeeService.getEmp(id);
        return Msg.Success().add("emp",emp);

    }

//    更新
    @ResponseBody
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
    public Msg ModifyEmp(Employee employee){

        Integer s = employeeService.ModifyEmp(employee);
        return  s>0?Msg.Success():Msg.fail();
    }
//单个删除
//    @ResponseBody
//    @RequestMapping(value ="emp/{id}",method = RequestMethod.DELETE)
//    public Msg deleteEmp(@PathVariable("id") Integer id){
//
//        Integer jude = employeeService.deleteEmp(id);
//
//        return jude>0?Msg.Success():Msg.fail();
//    }
/*单个批量(删除)二合一
      批量删除：1-2-3
*     单个删除：1
*/
    @ResponseBody
    @RequestMapping(value ="emp/{ids}",method = RequestMethod.DELETE)
    public Msg deleteSelectEmp(@PathVariable("ids") String ids){
        Integer jude = null;
        if(ids.contains("-")){

            List<Integer> iDs=new ArrayList<>();
            //说明是批量删除
            String[] split = ids.split("-");
            for(String s:split){
                iDs.add(Integer.parseInt(s));
            }
            jude=employeeService.deleteBatchEmp(iDs);
        }else{
            //说明是单个删除
            jude = employeeService.deleteEmp(Integer.parseInt(ids));

        }

        return jude>0?Msg.Success():Msg.fail();
}
}