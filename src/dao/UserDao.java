package dao;

import com.google.gson.Gson;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;
import utils.UserHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private QueryRunner queryRunner;
    private static UserDao instance = new UserDao();

    private UserDao(){
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSources());
    }

    public static UserDao getInstance(){
        return instance;
    }


    public int addUser(String name, String password, String avatar, String is_merchant) {

        int a = 0;
        String sql = "insert into user values (null, ?, ?, ?, ?)";
        try {
            //int a = queryRunner.update(sql, "window", "name", "13:07", "food");
            a = queryRunner.update(sql, name, password, avatar, Integer.valueOf(is_merchant));

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return a;
    }


    public int deleteUser(String sd) {

        int id = Integer.valueOf(sd);
        String sql = "delete from user where id = ?";
        try {
            int a = queryRunner.update(sql, id);
            System.out.print(a);

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return id;

    }


    public String queryUsers() {
        String sql = "select * from user";
        String jsonString = null;
        try {
            List<User> list = queryRunner.query(sql, new UserHandler());
            Gson gson = new Gson();
            jsonString = gson.toJson(list);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return jsonString;
    }



    public int updateUser(String id, String name, String password, String avatar){

        String sql = "update user set name = ? , password = ? , avatar = ? where id = ?";
        int updateId = Integer.valueOf(id);
        try {
            int update = queryRunner.update(sql, name, password, avatar, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateId;

    }


}
