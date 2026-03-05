package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
//AUTO , IDENTITY(MySQL) , SEQUENCE(PostGRES,Oracle) , TABLES(Composite kwy)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}