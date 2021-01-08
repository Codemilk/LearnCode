package MVC.Controller;

import CrowedFunding_Entity.Admin;
import CrowedFunding_Entity.Student;
import Util.CrowdUtil;
import Util.ResultEntity;
import Service.service.AdminServie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
//父路径
@RequestMapping("/test")
public class TestHandler {

     private Logger logger =
             LoggerFactory.getLogger(TestHandler.class);

     @Autowired
     private AdminServie adminServie;

//     异步ajax
     @RequestMapping("/ajax/async.html")
     public String ajaxAsync() throws InterruptedException {

        Thread.sleep(2000);
         return "login";
     }


     @RequestMapping("/ExceptionHandler")
     @ResponseBody
    public ResultEntity<Student> testExceptionHandler(@RequestBody Student student, HttpServletRequest request){

         String s=null;
         System.out.println(s.length());

        return ResultEntity.successWithData(student);
    }



    @RequestMapping("/testConfuseJson.json")
    @ResponseBody
    public ResultEntity<Student> testConfuseJson(@RequestBody Student student, HttpServletRequest request){

        boolean judgeRequest = CrowdUtil.judgeRequestType(request);


        logger.info("judgeRequest："+judgeRequest);

//        logger.info("student:"+student);
//        ResultEntity<Student> studentResultEntity=ResultEntity.successWithData(student);
/**       直接这样返回就相当于上面一行一样*/
        return ResultEntity.successWithData(student);
    }



    @RequestMapping("/testJson.html")
    @ResponseBody
    public String testJson(@RequestBody List<Integer>arr){

        //创建日志对象，通过日志数据输出方便后期管理

        for(Integer i:arr){

            logger.info("number:"+i);
        }

        return "success";

    }



    @RequestMapping("/ssm.html")
    public String testSSM(Map map,HttpServletRequest request){
        List<Admin> all = adminServie.getALL();
        map.put("all",all);

//        String s=null;
//        System.out.println(s.length());
//
        int i=1/0;
        return "Target";
    }
}
