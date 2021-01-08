package Transaction.Junit5;

import Transaction.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ExtendWith(SpringExtension.class)//单元测试框架
//@ContextConfiguration("classpath:SpringTransaction_Aop.xml")//加载配置文件
//简化注解
@SpringJUnitConfig(locations = "classpath:SpringTransaction_Aop.xml")
public class JTest5 {
    @Autowired
    private UserService userService;


    @Test
    public void test(){
        userService.TransferMoney();
    }

}
