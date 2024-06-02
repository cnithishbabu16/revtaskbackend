package com.taskmanagement.fannss.repository;

import com.taskmanagement.fannss.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
