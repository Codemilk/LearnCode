package Test;


import Bean.Department;
import Bean.Employee;
import Mapper.DepartmentMapper;
import Mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author lenovo
 */
public class MybatisTest2 {

    static String  resource="mybatis-config.xml";
    private static InputStream in = null;
    private static  SqlSessionFactory sqlSessionFactory=null;
    static {
        try {
            in = Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testResultMapPlus(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);


        Employee employeeById = mapper.getEmployeeById(1);

        System.out.println(employeeById);
    }

    @Test
    public void testResultMap_associationPlus1(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);


        Employee employeeById = mapper.getEmployeeAndDept(4);

        System.out.println(employeeById);
    }

    @Test
    public void testResultMap_Step(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee employeeAndDeptByStep = mapper.getEmployeeAndDeptByStep(3);

//        DepartmentMapper mapper1 = sqlSession.getMapper(DepartmentMapper.class);
//
//        Department departmentById = mapper1.getDepartmentById(1);

        System.out.println(employeeAndDeptByStep);

    }

    @Test
    public void testResultMap_Collection(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department employeeByIdPlus = mapper.getEmployeesByIdPlus(1);

        System.out.println(employeeByIdPlus);


    }

    @Test
    public void testResultMap_CollectionByStep(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department departmentByIdStep = mapper.getDepartmentByIdStep(1);


        System.out.println(departmentByIdStep);
    }

    @Test
    public void testDiscriminnor(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
        EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);

        Employee employeeByDidGender = mapper.getEmployeeByDidGender(1);

        System.out.println(employeeByDidGender);
    }

}
