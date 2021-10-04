


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class H2JDBC {
	Scanner sc=new Scanner(System.in);
    private static String jdbcURL = "jdbc:h2:~/college";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "password";

    private static final String createTableSQL = "create table student (\r\n" + "  id  int(3) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
            "  password varchar(20)\r\n" + "  );";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO student" +
            "  (id, name, email, country, password) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String QUERY = "select id,name,email,country,password from student";
    
    private static final String UPDATE_USERS_SQL = "update student set name = ? where id = ?;";
    
    private static final String deleteTableSQL = "delete from student where id = ?";
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void Createtable()
    {
    	System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBC.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
            
            statement.close();
    		connection.close();

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBC.printSQLException(e);
        }
        
		
    }
    
    public static void DisplayTable()
    {
    	// using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBC.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            //preparedStatement.setInt(1, 1);
           // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + " : " + name + "," + email + "," + country + "," + password);
                
                
            }
            rs.close();
            preparedStatement.close();
    		connection.close();
        } catch (SQLException e) {
            H2JDBC.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
    public static void InsertTable()
    {
    	Scanner sc =new Scanner(System.in);
    	//System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBC.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	System.out.println("Enter values to insert : ");
    		System.out.println("Id : ");
    		int id=sc.nextInt();
    		System.out.println("Name : ");
    		String name = sc.next();
    		System.out.println("Email : ");
    		String email=sc.next();
    		System.out.println("Country : ");
    		String country = sc.next();
    		System.out.println("Password : ");
    		String password = sc.next();
    		System.out.println("Inserting records into the table...");  
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            
            System.out.println("Insert Executed");
            
            preparedStatement.close();
    		connection.close();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBC.printSQLException(e);
        }

    }
    public static void DeleteTable()
    {
    	Scanner sc=new Scanner(System.in);
    	 //System.out.println(deleteTableSQL);
         // Step 1: Establishing a Connection
         try (Connection connection = H2JDBC.getConnection();
             // Step 2:Create a statement using connection object
        		 PreparedStatement preparedStatement = connection.prepareStatement(deleteTableSQL);) {

        	 System.out.println("Enter id to delete : ");
     		System.out.println("Id : ");
     		int id=sc.nextInt();
        	 preparedStatement.setInt(1, id);
             // Step 3: Execute the query or update query
        	 preparedStatement.execute();
   	      System.out.println("Deleted record from the table...");  
             
   	        preparedStatement.close();
     		connection.close();

         } catch (SQLException e) {
             // print SQL exception information
             H2JDBC.printSQLException(e);
         }
    }
    public static void UpdateTable()
    {
    	Scanner sc=new Scanner(System.in);
    	//System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBC.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
        	System.out.println("Enter id to update : ");
    		System.out.println("Id : ");
    		int id=sc.nextInt();
    		System.out.println("Name : ");
    		String name = sc.next();
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            
System.out.println("Update Executed");
            
            preparedStatement.close();
    		connection.close();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBC.printSQLException(e);
        }
    }
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}