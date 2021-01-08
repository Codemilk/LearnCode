package Service.Impl;


import CrowedFunding_Entity.Role;
import CrowedFunding_Entity.RoleExample;
import Mapper.RoleMapper;
import Service.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    //查询已经分配的角色
    @Override
    public List<Role> getAssignRole(Integer id) {
        return roleMapper.selectAssignRole(id);
    }
    //查询没有分配的角色
    @Override
    public List<Role> getUnAssignRole(Integer id) {
        return roleMapper.selectUnAssignRole(id);
    }


    @Override
    public PageInfo getPage(String keyword, int pageNum, int pageSize) {
        //1.开启分页功能
        PageHelper.startPage(pageNum, pageSize);
        //2.获取数据
        List<Role> roles = roleMapper.selectRoleByKeyword(keyword);
        //3.创建分页类
        PageInfo pageInfo=new PageInfo(roles);

        return pageInfo;
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {

        roleMapper.updateByPrimaryKey(role);

    }

    @Override
    public void deleteRole(List<Integer> list) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIn(list);
        roleMapper.deleteByExample(roleExample);
    }

}
