package com.Nekha.freelancer.freelancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nekha.freelancer.RequestModel.LoginRequest;
import com.Nekha.freelancer.RequestModel.MailResponse;
import com.Nekha.freelancer.freelancer.model.User;
import com.Nekha.freelancer.freelancer.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));

        user.setFirst_name(userDetails.getFirst_name());
        user.setLast_name(userDetails.getLast_name());
        user.setAge(userDetails.getAge());
        user.setEmail(userDetails.getEmail());
        user.setPhone_number(userDetails.getPhone_number());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    
    
    public String loginUser(LoginRequest loginRequest) {
        // Find the user by email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NoSuchElementException("User not found with email: " + loginRequest.getEmail()));

        // Check if the passwords match
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        return "Login successful"; // You can return a token or session ID here if needed
    }
    
    public User getByMail(String mail) {
    	User user = userRepository.findByEmail(mail).orElseThrow(() -> new NoSuchElementException("User not found with email: " + mail));
    	if(user == null) {
    		throw new IllegalArgumentException("No user found");
    	}
    	return user;
    }

    public MailResponse getEmailsByIds(Long userId1) {
        
        // Retrieve users by their IDs
        User user1 = userRepository.findById(userId1).orElse(null);
    
        
           String a  = user1.getEmail();
          

           return new MailResponse(a);
    }
        
}
