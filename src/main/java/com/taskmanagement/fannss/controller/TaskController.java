package com.taskmanagement.fannss.controller;

import com.taskmanagement.fannss.DTO.CreateTaskDTO;
import com.taskmanagement.fannss.DTO.TaskDTO;
import com.taskmanagement.fannss.entity.Task;
import com.taskmanagement.fannss.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
            @RequestHeader("userId") Long userId,
            @RequestBody CreateTaskDTO createTaskDTO) {

        // Set userId and role in the DTO
        createTaskDTO.setAssignedBy(userId);

        // Assuming taskService.createTask creates the task and saves it
        TaskDTO task = taskService.createTask(createTaskDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId, @RequestParam Long userId) {
        taskService.deleteTask(taskId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDetails) {
        TaskDTO  tdo = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(tdo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id){
          return ResponseEntity.ok(taskService.getTask(id));
    }


    @PostMapping("/create")
    public ResponseEntity<TaskDTO> creasTask(
            @RequestHeader("userId") Long userId,@RequestBody TaskDTO taskDTO)
    {

         TaskDTO task=taskService.createTaskByUser(userId,taskDTO);
         return  ResponseEntity.ok(task);
    }


    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskDTO>> getAllTasksByUser(
            @RequestHeader("userId") Long userId){
        List<TaskDTO> ltd=taskService.getAllTasksUsers(userId);
        return  ResponseEntity.ok(ltd);
    }
}

