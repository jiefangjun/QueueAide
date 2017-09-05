package dao;

import com.google.gson.Gson;
import model.Unit;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;
import utils.UnitHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UnitDao {

    private QueryRunner queryRunner;
    private static UnitDao instance = new UnitDao();

    private UnitDao(){
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSources());
    }

    public static UnitDao getInstance(){
        return instance;
    }

    public int addUnit(String restaurant_name, String user_name, String product_name) {

        int a = 0;
        String time = String.valueOf(new Date().getTime());
        String sql = "insert into queue values (null, ?, ?, ?, ?)";
        try {

            a = queryRunner.update(sql, restaurant_name, user_name, product_name, time);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


    public String queryUnits() {
        String jsonString = null;
        String sql = "select * from queue";
        try {
            List<Unit> list = queryRunner.query(sql, new UnitHandler());
            Gson gson = new Gson();
            jsonString = gson.toJson(list);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return jsonString;
    }

    public int deleteUnit(String stringid){

        String sql = "delete from queue where id = ?";
        int id = Integer.valueOf(stringid);
        try{
            int a = queryRunner.update(sql, id);
            System.out.print(a);

        }catch (SQLException se){
            se.printStackTrace();
        }

        return id;
    }


    public int updateUnit(String id, String restaurant_name, String user_name, String product_name, String time) {

        String sql = "update user set restaurant_name = ? , user_name = ? , product_name = ? , time = ? , where id = ?";
        int updateId = Integer.valueOf(id);
        try {
            int update = queryRunner.update(sql, restaurant_name, user_name, product_name, time, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateId;
    }


}




