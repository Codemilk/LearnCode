package C3D0.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.bind.v2.util.DataSourceSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
//        //创建数据库池连接，默认配置
//       DataSource dataSource =new ComboPooledDataSource();
//       Connection cons=null;
//        for(int i=0;i<8;i++){
//            cons=dataSource.getConnection();
//            if(i==5){
//                cons.close();//归还
//            }
//            System.out.println(cons);
//        }
        testNameConfig();
    }
    //创建指定数据库
    public static void testNameConfig(){
        DataSource ds=new ComboPooledDataSource("otherc3p0");
        Connection conn=null;
        //获取链接
        for(int i=0;i<11;i++){
            try {
                conn=ds.getConnection();
                System.out.println(conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
