package jdbc_demoSHIWU;

import util.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class jdbc {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement prs=null;
        PreparedStatement pr=null;
        String sql1="update account set balance =balance-? where name=?";
        String sql2="update account set balance =balance+? where name=?";
        try {
            conn= jdbcUtils.getconnection();
            //开启事务
            conn.setAutoCommit(false);//意思是传进false 代表着你要手动提交，类似于数据的 start transcation 一样 如果不提交那么这个事务就会一直做下去，即使指令完成，
                                     // 也就在哪里听着，在这个是实验里如果不提交或者回滚的话，
                                    // 数据库永远接收不到变化
            prs=conn.prepareStatement(sql1);
            pr=conn.prepareStatement(sql2);
            prs.setDouble(1,500);
            prs.setString(2,"zhangsan");
            pr.setString(2,"lisi");
            pr.setDouble(1,500);
            prs.executeUpdate();
            //手动制造异常,当有异常发生的时候，直接步骤，异常下面的句子读不到
            int i=3/0;
            pr.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //如果出现问题就回滚以免造成数据缺失
            try {
                if(conn!=null)
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            jdbcUtils.close(prs,conn);
            jdbcUtils.close(pr,null);

        }

    }
}
