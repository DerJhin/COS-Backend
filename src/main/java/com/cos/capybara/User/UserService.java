package com.cos.capybara.User;

import org.springframework.stereotype.Service;

@Service
public class UserService implements DefaultUserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }
}
