

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class H2UpdateExample {

    private static final String UPDATE_USERS_SQL = "update account set name = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        H2UpdateExample updateStatementExample = new H2UpdateExample();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBC.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2, 1);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBC.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}
