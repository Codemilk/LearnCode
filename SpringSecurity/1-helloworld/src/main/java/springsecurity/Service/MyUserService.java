package springsecurity.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springsecurity.Entity.Users;
import springsecurity.Mapper.userMapper;

import java.util.List;


@Service("userDetailsService")
public class MyUserService implements UserDetailsService {

    @Autowired
    private userMapper userMapper;


//    @Override
//    //方法参数username就是从表单过滤器拦截下的用户名
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        //权能
//        List<GrantedAuthority> authority = AuthorityUtils.commaSeparatedStringToAuthorityList("root");
//
//        User user = new User(“tom”, new BCryptPasswordEncoder().encode(“666”), authority);
//        return user;
//    }

    @Override
    //方法参数username就是从表单过滤器拦截下的用户名
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**这里就是判断从表单获取的数据和数据库比对（数据库查询）*/
         //创建条件构造器
        QueryWrapper queryWrapper=new QueryWrapper();
         //这里就相当于where username(表的列名)=？
        queryWrapper.eq("username",username);
        Users users = userMapper.selectOne(queryWrapper);
        System.out.println(users.getUsername());
        if(users==null){
            throw new UsernameNotFoundException("meiyou");
        }
        //权能
        List<GrantedAuthority> authority = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");

        //这里的密码不用加密，数据库已经加密好了
        User user = new User(users.getUsername(),users.getPassword(), authority);
        return user;
    }


}
