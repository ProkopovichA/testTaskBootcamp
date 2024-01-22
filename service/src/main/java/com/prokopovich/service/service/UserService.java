package com.prokopovich.service.service;

import com.prokopovich.service.exception.UserAlreadyExistException;
import com.prokopovich.repository.entity.User;
import com.prokopovich.repository.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registration (User userEntity) throws UserAlreadyExistException {
        if(userRepository.findByEmail(userEntity.getEmail()) != null) {
            throw new UserAlreadyExistException("User with email:" + userEntity.getEmail() +" is already exist");
        }
        return userRepository.save(userEntity);
    }

    public List<User> findAllByOrderByEmail() {
        return userRepository.findAllByOrderByEmail();
    }

    public Page<User> findAllByOrderByEmail(Pageable pageable) {
        return userRepository.findAllByOrderByEmail(pageable);
    }

}
