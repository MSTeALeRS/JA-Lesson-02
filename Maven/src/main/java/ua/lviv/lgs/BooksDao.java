package ua.lviv.lgs;


import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {
    private static String READ_ALL = "select * from Library";
    private static String CREATE = "insert into Library(`name`, `writer`,`category`) values (?,?,?)";
    private static String READ_BY_ID = "select * from Library where id =?";
    private static String UPDATE_BY_ID = "update Library set name=?, writer = ?, category = ? where id = ?";
    private static String DELETE_BY_ID = "delete from Library where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BooksDao(Connection connection) {
        this.connection = connection;
    }

    public  void insert(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getWriter());
        preparedStatement.setString(3, book.getCategory());
        preparedStatement.executeUpdate();

    }

    public Book read(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return BookMapper.map(result);

    }

    public void update(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getWriter());
        preparedStatement.setString(3, book.getCategory());
        preparedStatement.setInt(4, book.getId());
        preparedStatement.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    public List<Book> readAll() throws SQLException {
        List<Book> Books2 = new ArrayList<>();

        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            Books2.add(BookMapper.map(result));
        }
        return Books2;
    }

}
