package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.Date;

public class AddUser {

    private static AddUser instance = new AddUser();

    private AddUser(){}

    public static AddUser getInstance() {
        return instance;
    }

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSources());
    String sql = "insert into queue_info values (null, ?, ?, ?, ?)";

    public int addUser(String windowName, String userName, String foodName){

        int a = 0;

        try{
            //int a = queryRunner.update(sql, "window", "name", "13:07", "food");
            Date date = new Date();
            String time = date.toString();
            a = queryRunner.update(sql, windowName, userName, time, foodName);

        }catch (SQLException se){
            se.printStackTrace();
        }

        return a;

    }
}
