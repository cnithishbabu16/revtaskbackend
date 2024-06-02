package com.taskmanagement.fannss.controller;

import com.taskmanagement.fannss.DTO.CreateUserDTO;
import com.taskmanagement.fannss.DTO.LoginDTO;
import com.taskmanagement.fannss.DTO.UserDTO;
import com.taskmanagement.fannss.entity.User;
import com.taskmanagement.fannss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO) {
        User user = userService.createUser(createUserDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<UserDTO>> getUsersByProjectId(@PathVariable Long projectId) {
        List<UserDTO> users = userService.getUsersByProjectId(projectId);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<CreateUserDTO>> getAllUsers(){
      List<CreateUserDTO> cud=userService.getAllUsers();
        return ResponseEntity.ok(cud);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateUserDTO> updateUser(@PathVariable Long id,@RequestBody User user){

          CreateUserDTO cd= userService.updateUser(id,user);
        return ResponseEntity.ok(cd);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Optional<User> user = userService.login(loginDTO);
        if (user.isPresent()) {
            User foundUser = user.get();
            return ResponseEntity.ok(new UserResponse(foundUser.getId(), foundUser.getUsername(), foundUser.getRole()));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    @GetMapping("/teamMembers")
    public  ResponseEntity<List<CreateUserDTO>> getAllTeamMemebrs(){
        List<CreateUserDTO> cud=userService.getAllUsers();
        List<CreateUserDTO> filteredUsers = cud.stream()
                .filter(user -> "Team Member".equals(user.getRole()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            User foundUser = user.get();
            return ResponseEntity.ok(new UserResponse(foundUser.getId(), foundUser.getUsername(), foundUser.getRole()));
        }
        return ResponseEntity.ok(null);
    }

    private static class UserResponse {
        private Long userId;
        private String username;
        private String role;

        public UserResponse(Long userId, String userName, String role) {
            this.userId = userId;
            this.username = userName;
            this.role = role;
        }

        // Getters and Setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return username;
        }

        public void setUserName(String userName) {
            this.username = userName;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

