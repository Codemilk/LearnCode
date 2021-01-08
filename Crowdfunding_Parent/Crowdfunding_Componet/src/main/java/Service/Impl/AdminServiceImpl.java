package Service.Impl;

import CrowedFunding_Entity.Admin;
import CrowedFunding_Entity.AdminExample;
import Mapper.AdminMapper;
import Service.service.AdminServie;
import Util.CrowdUtil;
import Util.CrowedConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import exception.LoginFailedException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminServie {

    @Autowired
    private AdminMapper adminMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void saveRoleWithAdmin(Integer id,List<Integer> roleIds) {

        //旧的数据如下：
        /** adminID  roleId
         *     1       1(要删除)
         *     1       2(要删除)
         *     1       3
         *
         * 新的数据
         * adminID  roleId
         *    1       1(本来就有)
         *    1       2(本来就有)
         *    1       3(本来就有)
         *    1       4(新的)
         *    为了简化数据，现根据adminID删除旧的数据，再根据roleIds保存新的数据
         * */
        adminMapper.deleteByRoleWithAdminRelationShip(id);
        if(roleIds!=null&&roleIds.size() > 0){
        adminMapper.insertByRoleWithAdminRelationShip(id,roleIds);
        }
    }

    @Override
    public void update(Admin admin) {

        adminMapper.updateByPrimaryKeySelective(admin);

    }




    @Override
    public Admin getAdminByid(Integer id) {

        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }



    @Override
    public void deleteUser(Integer id) {

        adminMapper.deleteByPrimaryKey(id);

    }


    @Override
    public PageInfo<Admin> selectAdmins(String keyWord,Integer pageNum,Integer pageSize) {

//        这里不可以直接PageHelper，el表达式只可识别这是一个list不是一个对象
        Page<Admin> page = PageHelper.startPage(pageNum, pageSize);

        List<Admin> admins = adminMapper.selectByContact(keyWord);

        PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);


        return pageInfo;
    }


    //存入admin
    @Override
    public void saveAdmin(Admin admin) {
        //密码加密
        String password=admin.getUserPswd();
        String MD5_password = CrowdUtil.MD5(password);
        admin.setUserPswd(MD5_password);

        //生成创建时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        admin.setCreateTime(format);


        adminMapper.insert(admin);





    }

    // 获得全体成员
    @Override
    public List<Admin> getALL() {
        return adminMapper.selectByExample(new AdminExample());
    }
    // 登入
    @Override
    public Admin getAdminByLogAct(String userName, String password) {

        // 1.根据账号查询Admin对象
        //创建adminExample对象，进行条件查询
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        AdminExample.Criteria s1 = criteria.andLoginAcctEqualTo(userName);

        List<Admin> admins = adminMapper.selectByExample(adminExample);


        // 2.查询是否为空，空则抛出异常，反之从数据库取出作比较
        if(admins == null || admins.size() == 0){
            throw new LoginFailedException(CrowedConstant.MESSAGE_LOAD_FAILED);
        } else if(admins.size()>1){
            throw new  LoginFailedException(CrowedConstant.LOGIN_NOR_NNIQUE);
        }
//        list问题！！！！！！！！！！！
        Admin admin=admins.get(0);
        // 3.将表单密码进行加密
        String userPswdFromForm = CrowdUtil.MD5(password);
        // 4.和数据库取出密码进行比较
        String userPswdFromDB =  admin.getUserPswd();
        // 5.一致返回对象反之抛出异常，

        // 使用Objects.equals(userPswdFromForm,userPswdFromDB)的好处是：
        // public static boolean equals(Object a, Object b) {
        // 先判断是不是同一个对象或者判断是不是同一个属性值
        // return (a == b) || (a != null && a.equals(b));

        if(!Objects.equals(userPswdFromDB,userPswdFromForm)){
            throw new LoginFailedException(CrowedConstant.MESSAGE_LOAD_FAILED);
        }
        return admin;

    }



}
