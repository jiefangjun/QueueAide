package utils;

import model.Unit;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitHandler implements ResultSetHandler<List<Unit>> {

    @Override
    public List<Unit> handle(ResultSet resultSet) throws SQLException {
        List<Unit> units = new ArrayList<Unit>();
        while (resultSet.next()){
            Unit unit = new Unit(resultSet.getInt("id"), resultSet.getString("restaurant_name"), resultSet.getString("user_name"
            ), resultSet.getString("product_name"), resultSet.getString("time"));
            units.add(unit);
        }
        return units;
    }
}
