package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by archie on 7/12/17.
 */
public class InitDataBase extends BaseDao{

    //创建各张表的sql语句
    static final String CREATE_RESTAURANT_TABLE = "CREATE TABLE restaurant" +
            "(id INTEGER NOT NULL, "+
            "name CHAR(255), "+
            "PRIMARY KEY (id))";

    static final String CREATE_PRODUCT_TABLE = "CREATE TABLE product" +
            "(id INTEGER NOT NULL, "+
            "(restaurant_id INTEGER NOT NULL,"+
            "name CHAR(255), "+
            "price CHAR(255),"+
            "PRIMARY KEY (id))";

    static final String CREATE_QUEUE_TABLE = "CREATE TABLE queue" +
            "(id INTEGER NOT NULL AUTO_INCREMENT, "+
            "restaurant_name CHAR(255), "+
            "user_name CHAR(255), "+
            "product_name CHAR(255), "+
            "time CHAR(255), "+
            "PRIMARY KEY (id));";


    public void initData(){
       createDatabases();
       executeSql(CREATE_RESTAURANT_TABLE);
       executeSql(CREATE_PRODUCT_TABLE);
       executeSql(CREATE_QUEUE_TABLE);

    }

    public void createDatabases(){

        try{
            //注册驱动
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            String sql = "CREATE DATABASE SMARTAIDE";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");


        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) statement.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        sayGoodBye();
    }

}
