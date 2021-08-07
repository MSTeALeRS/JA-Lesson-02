package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {



    public static Book map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String writer = result.getString("writer");
        String category = result.getString("category");

        return new Book(id,name, writer, category);
    }


}
