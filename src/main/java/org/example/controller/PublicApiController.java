package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/public")
public class PublicApiController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("test1")
    public String test1(){ return "API test 1"; }

    @GetMapping("test2")
    public String test2(){ return "API test 2"; }

    @GetMapping("users")
    public ResponseEntity<List<User>> users() {
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        log.info("fetching user with username {}", username);
        User user = this.userService.findByUsername(username);
        if (user.getUsername() == null) {
            log.error("user with username {} not found.", username);
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity
                .ok(user);
    }
}
