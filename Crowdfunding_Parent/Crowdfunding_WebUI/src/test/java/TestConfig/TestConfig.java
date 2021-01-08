package TestConfig;


import CrowedFunding_Entity.Admin;
import CrowedFunding_Entity.Role;
import Mapper.AdminMapper;
import Mapper.RoleMapper;
import Service.service.AdminServie;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:Spring_Mybatis.xml","classpath:Spring_Tx.xml"})
public class TestConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminServie adminServie;
    @Autowired
    private RoleMapper roleMapper;



    @Test
    public void testSql(){
        adminMapper.insertByRoleWithAdminRelationShip(10, Arrays.asList(1,2,3));
    }

//    SpringIOC，Mapper测试
    @Test
    public void test1() throws SQLException {

//        System.out.println(dataSource.getConnection());

//        adminMapper.insert(new Admin(null, "tom", "123123","tom", "tom@qq.com", null));
        /**
         * 若在实际开发中，所有想查看数值的地方都使用sysout方式打印，都会给项目上线运行带来问题，因为他本身是一种IO操作通常IO的操作都比较耗费性能
         * 即使你为了节省性能专门花时间删除代码sysout也可能有遗漏，而且麻烦
         * 而如果使用日志系统，那么就可以通过日志级别批量控制信息打印
         * 具体原因：https://ask.csdn.net/questions/1079638
         *
         * */
        System.out.println(adminMapper.selectByPrimaryKey(1));
    }
//日志测试

    @Test
    public void testLog(){
//         1.获取Logger对象,这里传入Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(TestConfig.class);

//        2.根据不同日志级别的打印日志
        logger.debug("Hello DEBUG");

        logger.info("Hello INFO");

        logger.warn("Hello WARN");
    }

//测试事务
    @Test
    public void testDataSourceTransactionManager(){

       adminServie.saveAdmin(new Admin(null, "jerry", "311311","jerry", "jerry@qq.com", null));

    }
//  批量插入用户数据
    @Test
    public void testInsert(){

        for(int i=40;i<100;i++){

            String s= UUID.randomUUID().toString().substring(0,5);
            adminMapper.insertSelective(new Admin(i,"Tom"+s, "123", "tom"+s, "tom@qq.com", null));
        }
    }


//  批量插入Role数据
    @Test
    public void testInsetRole(){


        for(int i=0;i<50;i++){
            String s= UUID.randomUUID().toString().substring(0,5);

            roleMapper.insert(new Role(null,s));
        }

    }
}

