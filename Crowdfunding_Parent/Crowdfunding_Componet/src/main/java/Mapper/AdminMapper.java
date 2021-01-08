package Mapper;

import java.util.List;

import CrowedFunding_Entity.Admin;
import CrowedFunding_Entity.AdminExample;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin  record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByContact(String keyWord);

    void insertByRoleWithAdminRelationShip(@Param("adminId") Integer id,@Param("roleList") List<Integer> roleList);

    void deleteByRoleWithAdminRelationShip(Integer id);
}