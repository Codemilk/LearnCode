package COM.Test;

import COM.bean.Department;
import COM.bean.Employee;
import COM.dao.DepartmentMapper;
import COM.dao.EmployeeMapperDao;
import COM.dao.EmployeeMapperPlus;
import COM.dao.daoMappersAnnotation.EmployeeMapperDaoAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
     static String resource="MyBatis-config.xml";
     static private SqlSessionFactory sqlSessionFactory=null;

     static {

         try {
             InputStream resourceAsStream = Resources.getResourceAsStream(resource);
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     /*
     *
     * 1.MyBatis允许增删改查直接（在接口上面）定义一下类型返回值：integer，long，boolean
     * 2.我们需要手动提交数据
     *
     * */
     @Test
    public void test() throws IOException {


         SqlSession sqlSession = sqlSessionFactory.openSession();

         EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

         Employee employee=new Employee(null,"c","1","c@qq.ciom");

          boolean b = mapper.addEmpById(employee);

          System.out.println(employee.getId());

          sqlSession.commit();
          sqlSession.close();

     }

     @Test
     public void test1() throws IOException {


          SqlSession sqlSession = sqlSessionFactory.openSession();

          EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

          Employee c = mapper.getEmpByIdAndLastName(1, "c");

          System.out.println(c);
          sqlSession.commit();
           sqlSession.close();
     }


     @Test
     public void test2() throws IOException {

          SqlSession sqlSession = sqlSessionFactory.openSession();

          EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

          Map a=new HashMap();
          a.put("id", 1);
          a.put("lastname", "c");
          a.put("tableName", "tbl_employee");

          Employee empByIdAndLastMap = mapper.getEmpByIdAndLastMap(a);

          System.out.println(empByIdAndLastMap);


          sqlSession.close();
     }


    @Test
    public void test3() throws IOException {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

        List<Employee> empsByLastName = mapper.getEmpsByLastName("%e%");


        for(Employee employee:empsByLastName){
            System.out.println(employee);
        }
        sqlSession.close();
    }
//返回值为map
    @Test
    public void test4() throws IOException {

       SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

        Map<Integer, Employee> empsByLastNameReturnMap = mapper.getEmpsByLastNameReturnMap("%e%");
        System.out.println(empsByLastNameReturnMap);

        sqlSession.close();
    }

//自定义结果映射测试
    @Test
    public void test5(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee empById = mapper.getEmpById(1);

        System.out.println(empById);


    }
    //联合查询
    @Test
    public void test6(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee empById = mapper.getEmpAndDept(1);

        System.out.println(empById);


    }
    //分布查询
    @Test
    public void test7(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee empById = mapper.getEmpByStep(1);


        System.out.println(empById.getLastname());


    }

    //分布查询
    @Test
    public void test8(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptNamePlus = mapper.getDeptNamePlus(1);
        System.out.println(deptNamePlus);
        System.out.println(deptNamePlus.getEmployees());


    }

    //分布查询
    @Test
    public void test9(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptByIdStep = mapper.getDeptByIdStep(2);


        System.out.println(deptByIdStep);

        System.out.println(deptByIdStep.getEmployees());


    }
    //discriminator
    @Test
    public void test10(){

        SqlSession sqlSession = sqlSessionFactory.openSession();


        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee deptByIdDiscriminator = mapper.getDeptByIdDiscriminator(2);

        System.out.println(deptByIdDiscriminator);
        System.out.println(deptByIdDiscriminator.getDept());



    }
}
