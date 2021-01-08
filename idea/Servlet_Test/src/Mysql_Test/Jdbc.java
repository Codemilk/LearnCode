package Mysql_Test;

import Druidconnection.Druid;
import org.springframework.jdbc.core.JdbcTemplate;

public class Jdbc {
      JdbcTemplate JT=new JdbcTemplate(Druid.getDataSource());

}
