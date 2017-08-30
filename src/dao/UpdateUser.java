package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;

public class UpdateUser {

    private static UpdateUser instance = new UpdateUser();

    private UpdateUser(){}

    public static UpdateUser getInstance(){
        return instance;
    }

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSources());
    //String sql = "update user set name = ? where id = ?";
    String sql = "update user set name = ? , password = ? , avatar = ? where id = ?";

    public int updateUserById(String id, String name, String password, String avatar){

        int updateId = Integer.valueOf(id);
        try {
            int update = queryRunner.update(sql, name, password, avatar, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateId;

    }

}
