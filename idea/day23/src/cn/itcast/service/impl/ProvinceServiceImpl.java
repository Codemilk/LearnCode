package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.jedis.test.Utils.JeidsPoolUtils;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public String findAllS() {

        /*

          使用缓存


         */

       // 先去查看redis中查询数据
        Jedis jedis= JeidsPoolUtils.getJedis();
        String province = jedis.get("province");
        if("".equals(province)||province.length()==0){
            //表明redis里面没有数据
            System.out.println("jedis没有数据");
            List<Province> all = provinceDao.findAll();

            //序列化成json
            ObjectMapper ob=new ObjectMapper();
            try {
               province = ob.writeValueAsString(all);
            } catch (Exception e) {
                e.printStackTrace();
            }

            jedis.set("Province", province);

            jedis.close();
        }else {
            System.out.println("redis有数据");
        }

        return province;
    }
}
