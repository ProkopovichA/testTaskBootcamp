package com.prokopovich.web.controller;

import com.prokopovich.repository.entity.User;
import com.prokopovich.service.exception.UserAlreadyExistException;
import com.prokopovich.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody User user) {
        try {
            userService.registration(user);
            String massage = "User successfully created";
            //logger.info(massage);
            return ResponseEntity.ok(massage);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(userService.findAllByOrderByEmail());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
