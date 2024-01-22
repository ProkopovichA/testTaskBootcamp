package com.prokopovich.web.controller;

import com.prokopovich.repository.entity.User;
import com.prokopovich.service.exception.UserAlreadyExistException;
import com.prokopovich.service.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity registration(@RequestBody User user) {
        try {
            userService.registration(user);
            String massage = "User successfully created";
            logger.info(massage);
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

    @GetMapping("/paged")
    public ResponseEntity getUsersPaged(Pageable pageable) {
        try {
            Page<User> usersPage = userService.findAllByOrderByEmail(pageable);

            if (usersPage.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(usersPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
