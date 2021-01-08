package Source;

import Bean.Employee;
import Mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lenovo
 */
public class sourceTest {

    /**
     1.获取sqlSessionFactory
     2.获取sqlSession对象
     3.获取接口的实现类对象(MapperProxy)
     4.执行增删改查方法
     **/


    @Test
    public void HelloWorld() throws IOException {

        String resources="mybatis-config.xml";

        InputStream sql1 = Resources.getResourceAsStream(resources);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(sql1);

        SqlSession sqlSession = build.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.getEmployee(1);

        System.out.println(employee);

    }


}