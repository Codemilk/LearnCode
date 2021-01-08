package Service.Impl;

import CrowedFunding_Entity.Auth;
import CrowedFunding_Entity.AuthExample;
import Mapper.AuthMapper;
import Service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Integer> getAuthsId(Integer id) {

        List<Integer> integers = authMapper.selectAuthsId(id);
        return integers;
    }

    @Override
    public void saveAuth(Map<String,List<Integer>> map) {
        //获取rolesId的值
        List<Integer> roleId =  map.get("rolesId");
        Integer id = roleId.get(0);

        //获取authIdArray
        List<Integer> authIdArray =map.get("authIdArray");


        System.out.println(authIdArray);

        //删除旧的关联关系
        authMapper.deleteByroleId(id);
        if(authIdArray.size() > 0&&!authIdArray.isEmpty()){
        authMapper.insertAuthByRoleid(authIdArray,id);
        }

    }


    @Override
    public List<Auth> getAuth() {
        List<Auth> auths = authMapper.selectByExample(new AuthExample());
        return auths;
    }

}
