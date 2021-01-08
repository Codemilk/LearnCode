package COM.Test;

import COM.bean.Department;
import COM.bean.Employee;
import COM.dao.DepartmentMapper;
import COM.dao.EmployeeMapperDao;
import COM.dao.EmployeeMapperDynamicSQL;
import COM.dao.EmployeeMapperPlus;
import COM.dao.daoMappersAnnotation.EmployeeMapperDaoAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class MyBatisTest {
    static  String resource="MyBatis-config.xml";
    static  SqlSessionFactory sqlSessionFactory=null;
    static  SqlSession sqlSession=null;

    static {

        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

             sqlSession = sqlSessionFactory.openSession();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testIF(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        Employee employee=new Employee(null,"%e%", "1",null );
        List<Employee> empByConditionIf = mapper.getEmpByConditionIf(employee);
        System.out.println(empByConditionIf);

    }


    @Test
    public void testTrim(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        Employee employee=new Employee(null,"%e%", null,null );
        List<Employee> empByConditionTrim = mapper.getEmpByConditionTrim(employee);

        for(Employee e:empByConditionTrim){
            System.out.println(e);
        }
    }
    @Test
    public void testChoose(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        Employee employee=new Employee(null,null, null,null);
        List<Employee> empByConditionChoose = mapper.getEmpByConditionChoose(employee);

        for(Employee e:empByConditionChoose){
            System.out.println(e);
        }

    }

    @Test
    public void testSet(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        Employee employee=new Employee(1,"a1dmin", null,null);
        mapper.updateEmp(employee);

        sqlSession.commit();

    }
    @Test
    public void testForeach(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        Employee employee=new Employee(1,"a1dmin", null,null);
        List<Employee> empsByConditionForeach = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3));

        for(Employee e: empsByConditionForeach){
            System.out.println(e);
        }

    }

    @Test
    public void testInsertByForeach(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

       List<Employee> employees=new ArrayList<>();

        employees.add(new Employee(null, "sim", "0", "d",new Department(1)));

        employees.add(new Employee(null,"ddaas","1","aad",new Department(2)));

        mapper.addEmpsByForeach(employees);
        sqlSession.commit();

        sqlSession.close();


    }
    @Test
    public void testPara(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        List<Employee> empTestPara = mapper.getEmpTestPara(new Employee(null,"%e%", "0", "1",1));

        System.out.println(empTestPara);

    }
    @Test
    public void testBind(){

        EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

        List<Employee> empTestBind = mapper.getEmpTestBind(new Employee(null, "a", "0", "1", 1));

        System.out.println(empTestBind);

    }

}
