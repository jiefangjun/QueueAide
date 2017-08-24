package utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by archie on 7/14/17.
 */
public class JDBCUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource(); //自动加载默认配置文件

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    public static ComboPooledDataSource getDataSources(){
        return dataSource;
    }
}
