package sources;

import Bean.Employee;
import Mappers.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Helloworld {
    /**
     * 1.获取sqlSessionFactory对象：
     *          解析文件的每一个对象保存在Configuration中，返回包含Configuration的DefaultSqlSessionFactory对象
     *
     * 2.获取sqlSession对象
     *             返回一个DefaultSQLSession对象，包含Executor和Configuration
     *
     *3.获取接口的代理对象(MapperProxy)
     *            getMapper,使用MapperProxyFactory创建一个MapperProxy的代理对象
     *            代理对象里面包含了，DefaultSqlSession（Executor）
     *
     *总结：1.根据配置文件初始化一个 Configuration，包含DefaultSqlSessionFactory对象
     *     2.创建一个DefaultSqlSession对象
     *         包含Executor和Configuration
     *     3.DefaultSqlSession.getMapper（）获得mapper接口的MapperProxy
     *     4.MapperProxy里面包含（个DefaultSqlSession）
     *     5.执行方法，执行DefaultSqlSession（Executor）
     *                会创建一个StatementHandler对象，同时创建ParameterHandler（预编译参数一级设置参数值）和ResultSetHandler（处理结果），两个都基于TypeHandler
     *                执行statement增删改查方法
     *                ResultSetHandler封装结果
     * 注意：四大对象各司其职，都会有拦截器链的封装过程
     *
     *
     */

    @Test
    public void HelloWorld() throws IOException {

        String resources= "mybatis-config.xml";

        InputStream sql1 = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(sql1);

        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectByPrimaryKey(1);

        System.out.println(employee);


    }
/**
 *

     插件编写：
             1.编写 实现接口Interceptor的实现类
 *           2.Intercepts注解
 *             //Intercepts表示为当前插件注册
 *
 *           使用@Intercepts({
 *          @Signature 表示签名告诉你的插件，为哪一个类，哪一个方法，传入什么参数
 *         @Signature(type = StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
 * })
 *
 */

       @Test
       public void testPlugin() throws IOException {


           String resources= "mybatis-config.xml";

           InputStream sql1 = Resources.getResourceAsStream(resources);

           SqlSessionFactory build = new SqlSessionFactoryBuilder().build(sql1);

           SqlSession sqlSession = build.openSession(true);

           EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

           System.out.println(mapper);



       }
 }
