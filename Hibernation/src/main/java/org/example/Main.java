package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskDAO taskDAO = new TaskDAO();

        // Create Task 1
        Task task1 = new Task();
        task1.setTask("Learn Hibernate");
        task1.setDescription("Complete Hibernate tutorial");

        TaskDTO createdTask1 = taskDAO.create(task1);
        System.out.println(createdTask1);

        // Create Task 2
        Task task2 = new Task();
        task2.setTask("Build REST API");
        task2.setDescription("Complete REST API tutorial");

        TaskDTO createdTask2 = taskDAO.create(task2);
        System.out.println(createdTask2);

        // Read
        TaskDTO readTask = taskDAO.read(1L);
        System.out.println("Read: " + readTask);

        // Update
        TaskDTO updatedTask = taskDAO.update(1L,
                "Learn Advanced Hibernate",
                "Complete advanced mapping");
        System.out.println("Updated: " + updatedTask);

        // Get All
        List<TaskDTO> allTasks = taskDAO.getAllTasks();
        for (TaskDTO dto : allTasks) {
            System.out.println(dto);
        }

        // Delete
        boolean deleted = taskDAO.delete(2L);
        System.out.println("Deleted: " + deleted);

        taskDAO.close();
    }
}