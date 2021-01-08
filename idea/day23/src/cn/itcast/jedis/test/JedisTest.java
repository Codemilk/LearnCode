package cn.itcast.jedis.test;

import cn.itcast.jedis.test.Utils.JeidsPoolUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;


/*
   jedis测试类

 */
public class JedisTest {



    /*
      快速入门
     */
//   @Testq
    public void test1(){
       //1.获取连接
       Jedis jedis=new Jedis("localhost",6379);//如果是空参数，默认值："localhost"，6379

       //2.操作
      jedis.set("username", "张三");
       String username = jedis.get("username");
       System.out.println(username);
       //3.关闭连接
       jedis.close();
   }

//    @Testq
    public void test2(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);

        //2.操作

        //可以使用setex()方法可以指定过期时间的key value
        jedis.setex("active_code", 15, "dasd");//将active_code：dasd存入redis，并且20s后自动删除该键值对


        //3.关闭连接
        jedis.close();
    }


//    @Test
    public void test3(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);

        //2.操作
       jedis.hset("user", "name", "zs");
       jedis.hset("user", "gender", "man");


       //获取hash
        String hget = jedis.hget("user", "name");
        //获取所有的hash
        Map<String, String> user = jedis.hgetAll("user");

        System.out.println(hget);
        System.out.println(user);
        //3.关闭连接
        jedis.close();
    }

//    @Testq
    public void test4(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);

        //2.操作
       //jedis.lpush("user", "zj");
      //jedis.lpush("user", "zs");
      //jedis.lpush("user", "zf");

      //jedis.rpush("user", "zf");

       //删除指令
        jedis.lpop("user");


                //获取所有的jedis
        List<String> user = jedis.lrange("user", 0, -1);
        System.out.println(user);
//        jedis.del("user");
//        System.out.println(jedis.keys("localhost"));
        //3.关闭连接
        jedis.close();
    }

//    @Testq
    public void test5(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);

        //2.操作
        jedis.sadd("myset", "java","php","c++");
        Set<String> myset = jedis.smembers("myset");

        System.out.println(myset);
        jedis.del("myset");
        //3.关闭连接
        jedis.close();
    }

//    @Testq
    public void test6(){
        //1.获取连接
        Jedis jedis=new Jedis("localhost",6379);

        //2.操作

        //3.关闭连接
        jedis.close();
    }

//    @Testq
    public void test7(){

        //0.创建一个配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);//最大连接数
        config.setMaxIdle(10);//最大空闲数
        //1.获取连接

        JedisPool jedisPool=new JedisPool(config,"localhost",6379);

        //2.获取连接

        Jedis resource = jedisPool.getResource();

        //3.关闭归还
        resource.close();

    }

//    @Testq
    public void test8(){
        //从连接池获取


        Jedis jd=JeidsPoolUtils.getJedis();
        jd.sadd("a", "s");

        Set<String> a = jd.smembers("a");
        System.out.println(a);

    }
}
