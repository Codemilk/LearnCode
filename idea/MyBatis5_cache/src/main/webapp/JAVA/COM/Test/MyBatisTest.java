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

    static String resources="MyBatis-config.xml";
    static SqlSessionFactory sqlSessionFactory;
    static private   SqlSession sqlSession;

    static {

        try {

            sqlSessionFactory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resources));

             sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*
    * 两级缓存：
    *     一级缓存：（本地缓存） sqlSession级别的缓存，一级缓存是一直开启的，说白了就是一个sqlSession的map
    *               与数据库同一次会话期间查询到的数据会放在本地缓存中
    *               以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询。
    *               一级缓存失效的情况（没有使用当前到当前一级缓存的情况，效果就是，还需要在想数据库发出查询）
    *     一级缓存失效的情况：
    *               1.sqlSession不同，代表两次不同的会话
    *               2.sqlSession相同，但查询条件不一样
    *               3.sqlSession相同，但两次查询之间，增加增删改操作
     *              4.sqlSession相同，但手动清除了缓存
     *    二级缓存：（全局缓存）
     * */

    //一级缓存
    @Test
    public void testFirstLevelCache(){

        EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

        Employee empById = mapper.getEmpById(1);

        System.out.println(empById);

        //比如，当你查询了一次，你还需要再次查找一次，在传统的JDBC中，我们需要在监理一次会话等

        Employee empById1 = mapper.getEmpById(1);
        System.out.println(empById1);
        sqlSession.close();


    }

    //一级缓存失效的情况
    @Test
    public void testCacheUnSuccess(){

        EmployeeMapperDao mapper = sqlSession.getMapper(EmployeeMapperDao.class);

        Employee empById = mapper.getEmpById(1);

        System.out.println(empById);

        //sqlSession不同
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//
//        EmployeeMapperDao mapper1 = sqlSession2.getMapper(EmployeeMapperDao.class);
//
//        Employee empById1 = mapper1.getEmpById(1);
       //sqlSession相同， 但查询条件不同
//
//        Employee empById1 = mapper.getEmpById(2);
//
//        System.out.println(empById==empById1);
       //3.sqlSession相同，但两次查询之间，增加增删改操作

//        mapper.addEmpById(new Employee(null,"giaoge", "0", "654@qq.com0"));
//
//        System.out.println("add Success");
//
//        Employee empById1 = mapper.getEmpById(1);
//
//        System.out.println(empById==empById1);
//      4.sqlSession相同，但手动清除了缓存
        sqlSession.clearCache();
        Employee empById1 = mapper.getEmpById(1);

        System.out.println(empById==empById1);

    }
    /*二级缓存：（全局缓存）：
            二级缓存：（全局缓存）：基于namespace级别的缓存，一个namespace代表一个二级缓存**
                    工作机制：
                              1.一个会话：查询一条数据，这个数据就会被放在当前会话的一级缓存中
                              2.如果会话关闭后，对应的一级缓存就会保存到二级缓存中，新的会话查询信息，就可以参照二级缓存
                              3.一个namespace对应一个二级缓存 ，不同namespace查出的数据会放在自己的Map
                       注意：数据会从二级缓存查找的前提。是上一个sqlSession必须关闭
                       （默认顺序：一级缓存---（这个sqlSession提交或关闭）二级缓存）
                    使用：
                            1.开启全局二级缓存配置：在mybatis的全局变量配置         <setting name="cacheEnabled" value="true"/>
                            2.去mapper.xml中配置使用二级缓存
                                    <cache></cache>
                                eviction=“FIFO”：缓存回收策略
                                    •LRU –最近最少使用的：移除最长时间不被使用的对象。
                                    •FIFO –先进先出：按对象进入缓存的顺序来移除它们。
                                    •SOFT –软引用：移除基于垃圾回收器状态和软引用规则的对象。
                                    •WEAK –弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。
                                    •默认的是LRU。
                               flushInterval：刷新间隔，单位毫秒
                                    •默认情况是不设置，也就是不清空
                               size：引用数目，正整数
                                    •代表缓存最多可以存储多少个对象，太大容易导致内存溢出
                               readOnly：只读，true/false
                                    •true：只读缓存；会将数据的引用交给用户，说白了，速度快，不安全
                                    •false：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是false。
                               type:指定自定义的缓存的全类名
                            3.我们的POJO需要实现序列化
                    和缓存有关的设置/属性：
                                   1.CacheEnabled=true/false：表示开启/关闭二级缓存  （一级缓存不可以被关闭）
                                   2.useCache=true/false：mapper文件中每一个select标签都拥有这个属性，表示使用二/不使用级缓存
                                   3.flushCache=true：mapper文件中每一个增删改标签都拥有，表示当前这个方法执行完毕清除缓存(一级二级全都会被清除)
                                   4.sqlSession2.clearCache();表示只清楚当前session的一级缓存
                                   5.localCacheScope：本地缓存（一级缓存）作用域：（一级缓存SESSION）当前会话的所有数据保存在会话缓存
    */

    @Test
    public void SecondLevelCacheTest(){

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        EmployeeMapperDao mapper1 = sqlSession1.getMapper(EmployeeMapperDao.class);
        EmployeeMapperDao mapper2 = sqlSession2.getMapper(EmployeeMapperDao.class);

        Employee empById = mapper1.getEmpById(1);
        System.out.println(empById);

        sqlSession1.close();

//        mapper2.addEmpById(new Employee(null,"heqe", "1", "dd"));
        //注意：这里的第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
        sqlSession2.clearCache();
        Employee empById2 = mapper2.getEmpById(1);
        System.out.println(empById2);

        sqlSession2.close();

        System.out.println(empById==empById2);





    }
}
