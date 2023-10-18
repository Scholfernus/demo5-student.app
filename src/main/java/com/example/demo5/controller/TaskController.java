package com.example.demo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping("/tasks")
    public String getTaskList(){
        return "tasks/tasks";
    }
@GetMapping("/addTask")
    public String addTask(){
        return "tasks/addTask";
}
}
