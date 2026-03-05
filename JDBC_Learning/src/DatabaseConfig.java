import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/task_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Hymo@369852";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
