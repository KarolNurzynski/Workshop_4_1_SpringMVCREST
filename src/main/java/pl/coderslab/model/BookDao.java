package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private static final String READ_ALL = "SELECT * FROM book;";

    public List<Book> readAll() {
        List<Book> users = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(READ_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book user = new Book();
                    user.setId(rs.getInt("id"));
                    user.setIsbn(rs.getString("isbn"));
                    user.setTitle(rs.getString("title"));
                    user.setAuthor(rs.getString("author"));
                    user.setPublisher(rs.getString("publisher"));
                    user.setType(rs.getString("type"));
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return users;
    }


}
