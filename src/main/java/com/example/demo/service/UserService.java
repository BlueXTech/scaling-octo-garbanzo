package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserMetadataById(String id) {
        return userRepository.findUserMetadataById(id);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

}
