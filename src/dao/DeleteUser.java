package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;

public class DeleteUser {

    private static DeleteUser instance = new DeleteUser();

    private DeleteUser(){

    }

    public static DeleteUser getInstance(){
        return instance;
    }

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSources());
    String sql = "delete from user where id = ?";

    public int deleteUserById(String sd){

        int id = Integer.valueOf(sd);
        try{
            int a = queryRunner.update(sql, id);
            System.out.print(a);

        }catch (SQLException se){
            se.printStackTrace();
        }

        return id;

    }
}
