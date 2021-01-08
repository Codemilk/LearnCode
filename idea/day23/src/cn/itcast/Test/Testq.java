package cn.itcast.Test;

import cn.itcast.domain.Province;
import cn.itcast.jedis.test.Utils.JeidsPoolUtils;
import cn.itcast.util.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class Testq {

    @Test
    public void test1() throws Exception {
//
//        Jedis jedis=JeidsPoolUtils.getJedis();
//        System.out.println(jedis);
//        String province = jedis.get("province");
//        if("".equals(province)||province.length()==0){
//            //表明redis里面没有数据
//            System.out.println("jedis没有数据");
//            List<Province> all = provinceDao.findAll();
//
//            //序列化成json
//            ObjectMapper ob=new ObjectMapper();
//            try {
//                province = ob.writeValueAsString(all);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            jedis.set("Province", province);
//
//            jedis.close();
    }



}
