import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection conn = DatabaseConfig.getConnection();
        Scanner sc = new Scanner(System.in);

        // Insert into tasks table
        PreparedStatement taskStmt = conn.prepareStatement(
                "INSERT INTO tasks(title, description) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );

        System.out.println("Enter Task Title:");
        sc.nextLine(); // Fix buffer issue
        String title = sc.nextLine();

        System.out.println("Enter Task Description:");
        String desc = sc.nextLine();

        taskStmt.setString(1, title);
        taskStmt.setString(2, desc);
        taskStmt.executeUpdate();

        // Get generated task id
        ResultSet rs = taskStmt.getGeneratedKeys();
        int taskId = 0;
        if (rs.next()) {
            taskId = rs.getInt(1);
        }

        // Insert into tasks_assigned table
        PreparedStatement assignStmt = conn.prepareStatement(
                "INSERT INTO tasks_assigned(task_id, assigned_to) VALUES (?, ?)"
        );

        System.out.println("Enter number of people to assign:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of person:");
            String person = sc.nextLine();

            assignStmt.setInt(1, taskId);
            assignStmt.setString(2, person);
            assignStmt.executeUpdate();
        }

        System.out.println("Task and assignments added successfully ✅");

        assignStmt.close();
        taskStmt.close();
        conn.close();
    }
}