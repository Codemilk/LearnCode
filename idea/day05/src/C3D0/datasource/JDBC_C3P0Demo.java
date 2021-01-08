package C3D0.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_C3P0Demo {
    public static void main(String[] args) throws SQLException {
        Connection cons=null;
        //创建数据库连接池对象
        DataSource datas=new ComboPooledDataSource();

            System.out.println(datas);
            cons=datas.getConnection();
            System.out.println(cons);

    }
}
