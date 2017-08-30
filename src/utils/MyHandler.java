package utils;

import model.User;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by archie on 7/14/17.
 */
public class MyHandler implements ResultSetHandler<List<User>> {

    @Override
    public List<User> handle(ResultSet resultSet) throws SQLException {

        List<User> users = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("avatar"), resultSet.getString("is_merchant"));
            users.add(user);
        }
        return users;
    }
}
