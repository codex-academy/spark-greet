package go.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GreeterJDBC extends GreeterBase {

    private final Connection connection;

    public GreeterJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateCount(String name) {
        try {
            CallableStatement findUser = connection.prepareCall("select * from person where first_name = ?");
            CallableStatement updateUser = connection.prepareCall("update person set counter = ? where first_name = ?");
            CallableStatement createUser = connection.prepareCall("insert into person (first_name, counter) values (?, 1);");

            findUser.setString(1, name);
            ResultSet rs = findUser.executeQuery();
            if (rs.next()) {

                int userCount = rs.getInt("counter");

                updateUser.setInt(1, userCount + 1);
                updateUser.setString(2, name);
                updateUser.execute();

            } else {
                createUser.setString(1, name);
                createUser.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> greetedPeople() {
        List<Person> greetedList = new ArrayList<>();
        try {
            CallableStatement findGreetedPeople = connection.prepareCall("select * from person");
            ResultSet greetedPeople = findGreetedPeople.executeQuery();
            while(greetedPeople.next()) {
                //
                greetedList.add(new Person(
                        greetedPeople.getInt("id"),
                        greetedPeople.getString("first_name"),
                        greetedPeople.getInt("counter")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return greetedList;
    }

    @Override
    public Integer getCount() {
        try {
            CallableStatement statement = connection.prepareCall("select count(*) as userCount from person");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("userCount");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
