package Rest.test;

import Rest.bean.Department;
import Rest.bean.Employee;
import Rest.dao.DepartmentMapper;
import Rest.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

//使用Spring的单元测试,可以直接autowired等
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring.xml"})
public class mapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sessionTemplate;
    @Test
    public void  test(){

//插入部门
//        departmentMapper.insertSelective( new Department(null,"开发部"));
//        departmentMapper.insertSelective( new Department(null,"测试部"));
//插入员工
//        employeeMapper.insertSelective(new Employee(null,"jerrt","M","jerry@qq.com",1 ) );
//批量插入员工
        EmployeeMapper mapper = sessionTemplate.getMapper(EmployeeMapper.class);


        for(int i=0;i<100;i++){

             String s=UUID.randomUUID().toString().substring(0,5);
            mapper.insertSelective(new Employee(null,s,"M",s+"@qq.com",1 ));

        }

    }


}
