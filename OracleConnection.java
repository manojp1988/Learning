import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by manojperiathambi on 2/9/16.
 */
public class OracleConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
            //STEP 2: Register JDBC driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
