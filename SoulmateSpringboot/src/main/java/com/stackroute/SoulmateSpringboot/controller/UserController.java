package com.stackroute.SoulmateSpringboot.controller;

import com.stackroute.SoulmateSpringboot.model.User;
import com.stackroute.SoulmateSpringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUser(), HttpStatus.OK);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) throws Exception {
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUser(@PathVariable int id) throws Exception {
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception {
        return (ResponseEntity<User>) ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/user/name")
    public ResponseEntity<List<User>> searchByName(@RequestParam(value = "firstName") String firstName) {
        return new ResponseEntity<List<User>>((List<User>) userService.searchByName(firstName), HttpStatus.OK);
    }

    @GetMapping("/user/gender")
    public ResponseEntity<List<User>> getAllByGender(@RequestParam(value = "gender") String gender) {
        return new ResponseEntity<List<User>>((List<User>) userService.getAllByGender(gender), HttpStatus.OK);
    }

    @GetMapping("user/age")
    public ResponseEntity<List<User>> searchByAge(@RequestParam(value = "age") int age) {
        return new ResponseEntity<List<User>>((List<User>) userService.searchByAge(age), HttpStatus.OK);

    }
}


