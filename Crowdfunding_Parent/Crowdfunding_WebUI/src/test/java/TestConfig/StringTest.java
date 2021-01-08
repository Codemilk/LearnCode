package TestConfig;

import Util.CrowdUtil;
import org.junit.Test;

public class StringTest {

    @Test
    public  void testMD5(){

        String s="123123";

        String s1 = CrowdUtil.MD5(s);

        System.out.println(s1);


    }
}
