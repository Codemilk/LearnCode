package Util;

import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lenovo
 */
public class CrowdUtil {

    public static boolean  judgeRequestType(HttpServletRequest request){

        //通过请求头的X-Requested-With属性值判断，null为普通请求 XMLHttpRequest为ajax请求 */
        String X_Requested_With = request.getHeader("X-Requested-With");

        //返回为true表示ajax，false表示普通请求
        return "XMLHttpRequest".equals(X_Requested_With);
    }

    /**
     * 明文字符串转进行Md5加密
     * @param source 传入明文字符串
     * @return  加密结果
     */
    public static String MD5(String source){

        // 1.判断字符穿是否合法
        if(source==null||source.length() == 0){
          // 2.不合法抛出运行异常
          throw new RuntimeException(CrowedConstant.MESSAGE_ILLEAGE);
        }


        try {
            // 3.创建MessageDigest，MessageDigest.getInstance(level)，level表示什么加密方式
            String level="md5";
            MessageDigest messageDigest=MessageDigest.getInstance(level);

            // 4.获取明文数组串对应的字节数组
            byte[] bytes = source.getBytes();
            // 5.执行加密
            byte[] digest = messageDigest.digest(bytes);

            // 6.方便传入数据库，创建BigInteger
            // singNum表示控制是正数还是负数 ，1表示整数
            int singNum=1;
            BigInteger big=new BigInteger(singNum,digest);
            //按照16进制将BigInteger转变为字符串
            int radix=16;

          String encode=big.toString(radix);

          return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
