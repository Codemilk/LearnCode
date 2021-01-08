package COM.Test;

import COM.bean.Employee;
import COM.dao.EmployeeMapperDao;
import COM.dao.daoMappersAnnotation.EmployeeMapperDaoAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
     static String resource="MyBatis-config.xml";
    /*
    * 流程：
    *      1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
    *            有数据源一些运行环境信息
    *
    *      2.sql映射文件，配置每一个sql，以及SQL的封装规则等，
    *      3.将sql映射文件注册在全局配置文件中
    *      4.写代码
    *              1.根据全局配置文件得到SqlSessionFactory
    *              2.使用sqlSession工厂，获取sqlSession对象使用他来执行增删改查
    *                      一个sqlSession代表着一次和数据库的一次会话，用完要关闭
    *              3.使用sql的唯一标识来告诉Mybatis执行那个sql，sql都是保存在
    * */


    @Test
    public  void test() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        /*sqlSession有两个参数，第一个为sql的唯一标识符，也即是id
                               第二个为执行sql的参数

         */
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee o = sqlSession.selectOne("com.Mybatis.EmployeeMapper.selectEMP", 1);

        System.out.println(o);
        sqlSession.close();

    }
    /*
    * 1.接口式编程：
    *    原生：  Dao==>DaoImpl
    *    MyBatis： Mapper==>xxMapper.xml
    * 2.sqlSession代表与数据库的一次会话：
    * 3.SqlSession和connection一样不是线程安全的，不可以作为成员变量，每次使用都应该去获取新的对象.、
    * 4.mapper接口没有实现类，但是myBatis会为这个接口生成一个代理对象
    *                 方法：sqlSession.getMapper(EmployeeMapperDao.class)会给你一个代理对象class com.sun.proxy.$Proxy3;
    * 5.两个重要的配置文件：
    *                MyBatis的全局配置文件，包含数据库连接池信息，事务管理器信息等.....系统运行环境信息
    *                sql映射文件：保存每一个sql语句的映射信息
    * */
    @Test
    public void test2() throws IOException {
        //1.获取sqlSessionFactory
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的实现类对象
        //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
        EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

        try {
            Employee empById = mapper.getEmpById(1);

          System.out.println(mapper.getClass());

          System.out.println(empById);
      }finally {
          sqlSession.close();
      }

    }

    @Test
    public void test3() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        EmployeeMapperDaoAnnotation mapper = sqlSession.getMapper(EmployeeMapperDaoAnnotation.class);
        Employee empById = mapper.getEmpById(1);

        System.out.println(empById);

    }
}
