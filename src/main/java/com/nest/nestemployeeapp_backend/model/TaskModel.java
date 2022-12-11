package com.nest.nestemployeeapp_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue
    private int id;
    private String task;
    private String status;
    private int employeeId;

    public TaskModel() {
    }

    public TaskModel(int id, String task, String status, int employeeId) {
        this.id = id;
        this.task = task;
        this.status = status;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}