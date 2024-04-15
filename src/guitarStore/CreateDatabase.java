package guitarStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateDatabase {

    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "root";
    private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/GuitarStoreDatabase";

    public void createDatabase() throws SQLException {

        try (Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);
                Statement stmt = conn.createStatement();)
        {
		        String sql = "CREATE DATABASE GuitarStoreDatabase;";

        		stmt.executeUpdate(sql);
         		System.out.println("Database created successfully.");

        } catch (SQLException e)
        {
            System.err.println(e);
        }

    }

}