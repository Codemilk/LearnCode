package Service.service;

import CrowedFunding_Entity.Auth;

import java.util.List;
import java.util.Map;

public interface AuthService {
    List<Auth> getAuth();

    List<Integer> getAuthsId(Integer id);

    void saveAuth(Map<String,List<Integer>> map);
}
