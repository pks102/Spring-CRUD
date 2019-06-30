package com.example.pks.model.controller;

import com.example.pks.model.User;
import com.example.pks.repository.UserRepository;
import com.example.pks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        System.out.println(user);

        User u = userService.saveUser(user);
        System.out.println(u);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
