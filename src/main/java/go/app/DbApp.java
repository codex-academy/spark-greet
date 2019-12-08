package go.app;

import java.sql.*;

public class DbApp {
    public static void main(String[] args) {

        try {
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/greeter");
             CallableStatement statement = connection.prepareCall("select * from person");
             ResultSet rs = statement.executeQuery();

             while(rs.next()) {
                 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("counter"));
                 System.out.println(rs.getString("first_name"));
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
