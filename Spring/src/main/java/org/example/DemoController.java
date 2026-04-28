package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    // 1️⃣ Simple GET API
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Welcome to Spring Boot!";
    }

    // 2️⃣ GET with Path Variable
    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    // 3️⃣ GET with Query Param
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // 4️⃣ POST API (Receive JSON)
    @PostMapping("/user")
    public Map<String, Object> createUser(@RequestBody Map<String, Object> user) {
        user.put("message", "User created successfully");
        return user;
    }

    // 5️⃣ PUT API (Update)
    @PutMapping("/user/{id}")
    public Map<String, Object> updateUser(@PathVariable int id, @RequestBody Map<String, Object> user) {
        user.put("id", id);
        user.put("message", "User updated successfully");
        return user;
    }

    // 6️⃣ DELETE API
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return "User with ID " + id + " deleted successfully";
    }
}
