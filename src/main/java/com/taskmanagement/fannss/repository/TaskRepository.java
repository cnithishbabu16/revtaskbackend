package com.taskmanagement.fannss.repository;
import com.taskmanagement.fannss.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAssignedToId(Long userId);
}
