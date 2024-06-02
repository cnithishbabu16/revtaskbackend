package com.taskmanagement.fannss.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taskmanagement.fannss.entity.Task;

import java.sql.Date;

public class TaskDTO {
    private Long id;
    private Long projectId;
    private String taskName;
    private String taskDescription;
    private Long assignedBy;
    private Long assignedTo;
    private String priority;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;


    private Date dueDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date completedDate;
    // Constructor
    public TaskDTO() {
        this.startDate = new Date(System.currentTimeMillis()); // Set startDate to the current date by default
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.projectId = task.getProject() != null ? task.getProject().getId() : null;
        this.taskName = task.getTaskName();
        this.taskDescription = task.getTaskDescription();
        this.assignedBy = task.getCreatedBy() != null ? task.getCreatedBy().getId() : null;
        this.assignedTo = task.getAssignedTo() != null ? task.getAssignedTo().getId() : null;
        this.priority = task.getPriority();
        this.status = task.getStatus();
        this.startDate = task.getStartDate();
        this.dueDate = task.getDueDate();
        this.completedDate = task.getEndDate();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }
}

