package com.taskmanagement.fannss.controller;
import com.taskmanagement.fannss.DTO.CreateClientDTO;
import com.taskmanagement.fannss.entity.Client;
import com.taskmanagement.fannss.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody CreateClientDTO createClientDTO) {
        Client client = clientService.createClient(createClientDTO);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}

