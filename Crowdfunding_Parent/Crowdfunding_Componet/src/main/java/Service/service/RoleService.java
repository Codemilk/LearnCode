package Service.service;

import CrowedFunding_Entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {


    public PageInfo getPage(String keyword, int pageNum, int pageSize);

    public void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(List<Integer> list);

    List<Role> getAssignRole(Integer id);

        List<Role> getUnAssignRole(Integer id);
}
