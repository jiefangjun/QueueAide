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
    String sql = "insert into user values (null, ?, ?, ?, ?)";

    public int addUser(String name, String password, String avatar, String is_merchant){

        int a = 0;

        try{
            //int a = queryRunner.update(sql, "window", "name", "13:07", "food");
            a = queryRunner.update(sql, name, password, avatar, Integer.valueOf(is_merchant));

        }catch (SQLException se){
            se.printStackTrace();
        }

        return a;

    }
}
