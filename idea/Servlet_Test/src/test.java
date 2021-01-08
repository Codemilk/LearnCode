import USER.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import userdao.userdaos;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class test {
    @Test
    public void test(){
        userdaos ud=new userdaos();
        User us=new User();
         us.setPassword("123");
         us.setUsername("superbaby");
//        User login = ud.login(us);
//        System.out.println(login);
    }
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        User us=new User();
        BeanUtils.setProperty(us, "hehe", "male");
        System.out.println(us);
    }

    public static void main(String[] args) {

    }
}
