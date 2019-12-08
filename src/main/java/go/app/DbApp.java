package go.app;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class DbApp {
    public static void main(String[] args) {


        try {
            URI uri = new URI("postgres://wcdefqhozxqdnj:57a890508b5204405949ca471607b9c7663fad1c9e598147722715059828c441@ec2-107-20-234-175.compute-1.amazonaws.com:5432/dfadaua2uvvvfo");

            String[] hostParts = uri.getUserInfo().split(":");
            String username = hostParts[0];
            String password = hostParts[1];
            String host = uri.getHost();

            int port = uri.getPort();

            String path = uri.getPath();
            String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);

            System.out.println(username);
            System.out.println(password);

            System.out.println(url);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


//        try {
//             Connection connection = DriverManager.getConnection("jdbc:postgres://localhost/greeter");
//             CallableStatement statement = connection.prepareCall("select * from person");
//             ResultSet rs = statement.executeQuery();
//
//             while(rs.next()) {
//                 System.out.println(rs.getString("id"));
//                 System.out.println(rs.getString("counter"));
//                 System.out.println(rs.getString("first_name"));
//             }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
