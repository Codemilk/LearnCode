package Service.service;

import CrowedFunding_Entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminServie {

    void saveAdmin(Admin admin);

    List<Admin> getALL();

    Admin getAdminByLogAct(String userName, String password);

    PageInfo<Admin> selectAdmins(String keyWord,Integer pageNum,Integer pageSize);

    void deleteUser(Integer id);

    Admin getAdminByid(Integer id);


    void update(Admin admin);

    void saveRoleWithAdmin(Integer id,List<Integer> roleList);
}
