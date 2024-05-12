package com.Nekha.freelancer.freelancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Nekha.freelancer.RequestModel.LoginRequest;
import com.Nekha.freelancer.RequestModel.MailResponse;
import com.Nekha.freelancer.freelancer.model.User;
import com.Nekha.freelancer.freelancer.service.UserService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        // Call the login method in the UserService
        return userService.loginUser(loginRequest);
    }
    
    
    @GetMapping("/getByEmail/{mail}")
    public User getByMail(@PathVariable String mail) {
    	return userService.getByMail(mail);
    }



    @GetMapping("/mail/{a}")
    public MailResponse getMethodName(@PathVariable Long a) {
        return userService.getEmailsByIds(a);
    }
    
}
