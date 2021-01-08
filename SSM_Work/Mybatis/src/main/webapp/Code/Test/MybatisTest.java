package Test;

import Bean.Employee;
import Mapper.EmployeeMapper;
import Mapper.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MybatisTest {


    @Test
    public void HelloWorld() throws IOException {

        String resources="mybatis-config.xml";

        InputStream sql1 = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(sql1);

        SqlSession sqlSession = build.openSession();

         Employee e= (Employee)sqlSession.selectOne("employeeMapper.SelectEmployee", "abc");

        System.out.println(e);

    }

    @Test
    public void testInterface() throws IOException {

         String resource="mybatis-config.xml";

         InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = build.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.getEmployee(1);


        System.out.println(employee);


    }

    @Test
   public void testMapperClass() throws IOException {

        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = build.openSession();

        EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);

        Employee employee = mapper.getEmployee(1);

        System.out.println(employee);

    }

    @Test
    public void  MybatisCRUD() throws IOException {

        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

//        在你的sqlsession创建时，填入参数true即可
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//
//        mapper.addEmployee(new Employee(666,"ddd",  "69541875@qq.com","M"));
//
        Employee w = new Employee(666, "666", "1875@qq.com", "w");
        mapper.updateEmployee(w);
        System.out.println(w.getId());

        //
//        Employee employee = mapper.getEmployee(666);
//        System.out.println(employee);
//        mapper.deleteEmployee(666);


    }

    @Test
    public void testParams() throws IOException {
        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

//        在你的sqlsession创建时，填入参数true即可
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee jerry = mapper.getEmployeeByIdAndLastName(3, "jerry");

        System.out.println(jerry);
    }

    @Test
    public void testMap() throws IOException {
        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

//        在你的sqlsession创建时，填入参数true即可
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map map=new HashMap();

        map.put("id", "1");
        map.put("gender","1");
        map.put("lastname", "a1dmin");
        Employee employeeByMap = mapper.getEmployeeByMap(map);

        System.out.println(employeeByMap);

    }

    @Test
    public void testGetEmployee_ListAndMap() throws IOException {
        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

//        在你的sqlsession创建时，填入参数true即可
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
/*        List
        List<Employee> q = mapper.getEmployee_List("1");

        ListIterator<Employee> employeeListIterator = q.listIterator();

        for (ListIterator<Employee> it = employeeListIterator; it.hasNext(); ) {
            Employee employee = it.next();
            System.out.println(employ-ee);
        }
*/
       Map<String,Object> map= mapper.getEmployeeMap(1);

        System.out.println(map);

    }

    @Test
    public void  testEmployee_Maps() throws IOException {
        String resource="mybatis-config.xml";

        InputStream in=Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);

//        在你的sqlsession创建时，填入参数true即可
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<Integer, Employee> a1dmin = mapper.getEmployee_Maps("%r%");

        System.out.println(a1dmin);


    }

}
