package com.example.demo5.controller;

import com.example.demo5.model.StudentModel;
import com.example.demo5.model.TaskModel;
import com.example.demo5.service.StudentService;
import com.example.demo5.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final StudentService studentService;
    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> taskList = taskService.getAllTasks();
        model.addAttribute("taskModel", taskList);
        return "tasks/tasks";
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        List<StudentModel> list = studentService.getStudentsList();
        model.addAttribute("studentModel", list);
        return "tasks/addTask";
    }
    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task){
        taskService.saveAddTask(task);
        return new RedirectView("/tasks");
    }
//    @PostMapping("/edit/{id}")
//    public RedirectView postEditTask(TaskModel task, Long id){
//        taskService.editTask(task, id);
//        return new RedirectView("tasks/tasks");
//    }
}
