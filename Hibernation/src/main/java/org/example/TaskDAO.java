package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public TaskDAO() {
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }

    public TaskDTO create(Task task) {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();

            System.out.println("Task created successfully with id: " + task.getId());
            return convertToDTO(task);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error creating task: " + e.getMessage());
            return null;
        }
    }

    public TaskDTO read(Long id) {
        try {
            Task task = em.find(Task.class, id);
            if (task != null) {
                return convertToDTO(task);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error reading task: " + e.getMessage());
            return null;
        }
    }

    public TaskDTO update(Long id, String taskName, String description) {
        try {
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);

            if (task != null) {
                task.setTask(taskName);
                task.setDescription(description);
                em.getTransaction().commit();
                return convertToDTO(task);
            } else {
                em.getTransaction().rollback();
                return null;
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error updating task: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);

            if (task != null) {
                em.remove(task);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error deleting task: " + e.getMessage());
            return false;
        }
    }

    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> taskList = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Task t";
            List<Task> tasks = em.createQuery(jpql, Task.class).getResultList();

            for (Task task : tasks) {
                taskList.add(convertToDTO(task));
            }

            System.out.println("Retrieved " + taskList.size() + " tasks from database");
            return taskList;

        } catch (Exception e) {
            System.out.println("Error retrieving tasks: " + e.getMessage());
            return taskList;
        }
    }

    private TaskDTO convertToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getDescription()
        );
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        System.out.println("Database connection closed");
    }
}