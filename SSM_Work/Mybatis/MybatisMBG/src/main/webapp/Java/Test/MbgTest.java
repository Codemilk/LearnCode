package Test;

import Bean.Employee;
import Bean.EmployeeExample;
import Mappers.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.net.httpserver.HttpServer;
import javafx.application.Application;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MbgTest {


    @Test
    public  void test() throws Exception {
       String Resource= "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(Resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectByPrimaryKey(1);

        System.out.println(employee);

    }


    @Test
    public  void testExample() throws Exception {
        String Resource= "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(Resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//        查询条件拼装
//     创建一个criteria
        EmployeeExample employeeExample=new EmployeeExample();
       EmployeeExample.Criteria criteria = employeeExample.createCriteria();
//     为你的criteria写上上查询条件
        criteria.andLastNameLike("%e%");
//        criteria.andGenderEqualTo("1");
//        criteria.andDIdIsNull();
//        在通过selectByExample查询
        List<Employee> employees = mapper.selectByExample(employeeExample);

        System.out.println(employees);

    }
    /**
     * 1.插件原理：
     *           在四大对象创建的时候
     *            1.每个对象出来的时候不是直接返回的，而是
     *              InterceptorChain.pluginAll(param)
     *            2.获取到所有的Interceptor，并通过plugin方法包装返回target对象
     *            3.插件机制，我们可以使用插件为目标对象创建一个代理对象，AOP
     *
     *2.步骤：
     *       1.编写插件，实现interceptor的接口
     *       2.使用@intercepts完成插件签名
     *       3.在你的Mybatis中，注册你的插件
     * @throws Exception
     */
    @Test
    public void testPlugins() throws IOException {
        String Resource= "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(Resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectByPrimaryKey(1);

        System.out.println(employee);


    }

    @Test
    public void testPageHelper() throws IOException {

        String Resource= "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(Resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
/**
 PageHelper
        Page<Object> objects = PageHelper.startPage(1, 5);

        System.out.println("当前页码"+objects.getPageNum());
        System.out.println("总记录数"+objects.getTotal());
        System.out.println("每页记录数"+objects.getPageSize());
        System.out.println("总页码"+objects.getPages());

 */

        Page<Object> objects = PageHelper.startPage(1, 5);

        List<Employee> emps = mapper.getEmps();
//        NavigateFirstPage表示显示最多页码数
        PageInfo pageInfo=new PageInfo(emps,5);

        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("每页记录数"+pageInfo.getPageSize());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("第一页"+pageInfo.getNavigateFirstPage());
        System.out.println("是否有下一页"+pageInfo.isHasNextPage());
        System.out.println("NavigateFirstPage"+pageInfo.getNavigatepageNums());


        /*
         assertEquals(1, page.getPageNum());
         assertEquals(10, page.getPageSize());
         assertEquals(1, page.getStartRow());
         assertEquals(10, page.getEndRow());
         assertEquals(183, page.getTotal());
         assertEquals(19, page.getPages());
         assertEquals(1, page.getFirstPage());
         assertEquals(8, page.getLastPage());
         assertEquals(true, page.isFirstPage());
         assertEquals(false, page.isLastPage());
         assertEquals(false, page.isHasPreviousPage());
         assertEquals(true, page.isHasNextPage());
         */
        System.out.println(emps);
    }


    @Test
    public void testBatch() throws IOException {

        String Resource= "mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(Resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        openSession方法内写入ExecutorType，告诉执行器可以复通
        SqlSession sqlSession = build.openSession(ExecutorType.BATCH);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

    }
}
