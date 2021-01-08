import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        ClassLoader  classLoader=Test.class.getClassLoader();
        Properties pro=new Properties();
        classLoader.getResourceAsStream("pro");


    }


}
