package com.taskmanagement.fannss.repository;

import com.taskmanagement.fannss.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT  p FROM Project p JOIN FETCH p.tasks t WHERE t.assignedTo.id = :userId")
    List<Project> findProjectsByTaskAssignedTo(@Param("userId") Long userId);
    List<Project> findByProjectManager_Id(Long projectManagerId);
}
