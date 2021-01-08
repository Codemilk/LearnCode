package Test;

import Bean.Department;
import Bean.Employee;

import Mapper.Dynamic_SQL;
import Mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author lenovo
 */
public class Mybatis3 {
//    动态sql

    @Test
    public  void testIf() throws IOException {
        String resources="mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee employee=new Employee((Integer) null, "%a%", null, null);

        System.out.println(employee);
        List<Employee> empByConditionIf = mapper.getEmpByConditionIf(employee);

        System.out.println(empByConditionIf);
    }

    @Test
    public  void testTrim() throws IOException {
        String resources="mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee employee=new Employee((Integer) null, "%a%", null, null);

        List<Employee> empByConditionIf = mapper.getEmpByConditionTrim(employee);


        for (Employee e:empByConditionIf){

            System.out.println(e);
        }

    }

    @Test
    public  void testChoose() throws IOException {
        String resources="mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee employee=new Employee((Integer) null, "%a%", null, null);

        List<Employee> empByConditionChoose = mapper.getEmpByConditionChoose(employee);

        for(Employee e:empByConditionChoose){
            System.out.println(e);
        }
    }

    @Test
    public  void testSet() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee employee = new Employee(1, "nafla", "666", "0");
        mapper.updateEmployee(employee);
    }

    @Test
    public  void testForEach() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

//        List<Employee> empByConditionForeach = mapper.getEmpByConditionForeach(Arrays.asList(1, 2, 3));
//        System.out.println(empByConditionForeach);
        Map m=new HashMap();
        m.put("1",1);
        m.put("2",2);
        System.out.println(m);
        List<Employee> empByConditionForeachMap = mapper.getEmpByConditionForeachMap(m);
        System.out.println(empByConditionForeachMap);


    }

    @Test
    public  void testForEachPILIANG() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        mapper.insertEmployeeForeach(Arrays.asList(new Employee(null,"666","a@qq.com","0",new Department(1)),new Employee(null,"bb","6954@qq.com","0",new Department(2))));
    }
    @Test
    public void test() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee employeeByInnerParam = mapper.getEmployeeByInnerParam(1,"%a%");

        System.out.println(employeeByInnerParam);
    }

    @Test
    public void testBind() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        Employee a = mapper.getEmployeeByBind("a",1);

        System.out.println(a);
    }


    @Test
    public void testRepeateSQL() throws IOException {
        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        Dynamic_SQL mapper = sqlSession.getMapper(Dynamic_SQL.class);

        System.out.println(mapper.getEmployeeByRepeatSql(1));

    }


/*
   Cache：
         一级缓存(本地缓存)：与数据库同一次会话期间查询到的数据回会放在本地缓存中，如果需要获得相同的数据，直接从缓存中拿，没必要再去查询数据库
                            一级缓存也叫sqlSession缓存，他是一只开启的
                           sqlSession失效的情况：
                                             1.sqlSession不同
                                             2.sqlSession相同，查询条件不同
                                             3.sqlSession相同，两次查询之间填入了增删改的操作，原因是增删改可能会对当前的数据进行了修改
                                             4.sqlSession相同手动清空了
         二级缓存(全局缓存)：基于namespace级别的缓存：一个namespace对应一个二级缓存
                          工作机制：
                               1.一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中
                               2.若这个会话关闭，一级缓存中的数据会被保存到二级缓存中，新的会话查询的数据 就可以参照二级缓存
                               3.如果sqlSession==》EmployeeMapper==》employee
                                                 》 DepartmentMapper==》Department


                                */

       @Test
    public void testFirstCache() throws IOException {
           String resources = "mybatis-config.xml";

           InputStream resourceAsStream = Resources.getResourceAsStream(resources);

           SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

           SqlSession sqlSession = build.openSession(true);

           EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

           Employee employee = mapper.getEmployee(1);

//           这里的sql只是调用一次，但是查了两次，所以说，把查出来的数据放到了缓存
           sqlSession.clearCache();

           System.out.println(employee);
           Employee employee1 = mapper.getEmployee(1);

           System.out.println(employee1);
           System.out.println(employee1==employee);


       }

    @Test
    public void testSecondCache() throws IOException {

        String resources = "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        SqlSession sqlSession2 = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper1 = sqlSession2.getMapper(EmployeeMapper.class);

        Employee employee = mapper.getEmployee(1);

        System.out.println(employee);

        sqlSession.close();

//        mapper.addEmployee(new Employee(null,"giao",  "666@.cc","0"));

        System.out.println(mapper1.getEmployee(1));



    }



}
