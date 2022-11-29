package com.example.docker;

import example.com.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/{name}/{password}")
    public ResponseEntity<User> getUser(@PathVariable String name, @PathVariable String password) {
        return ResponseEntity.ok(new User(name, password));
    }
}
