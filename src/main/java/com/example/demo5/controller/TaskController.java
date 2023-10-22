package com.example.demo5.controller;

import com.example.demo5.model.StudentModel;
import com.example.demo5.model.TaskModel;
import com.example.demo5.service.StudentService;
import com.example.demo5.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        List<StudentModel> list = studentService.getStudentList();
        model.addAttribute("studentModel", list);
        return "tasks/addTask";
    }

    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        taskService.saveAddTask(task);
        return new RedirectView("/tasks");
    }

    @GetMapping("/editTask/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        List<StudentModel> list = studentService.getStudentList();
        TaskModel taskModel = taskService.getTaskById(id);
        model.addAttribute("studentModel", list);
        model.addAttribute("taskModel",taskModel);
        return "tasks/editTask";
    }
    @PostMapping("/editTask/{id}")
    public RedirectView postEditTask(@PathVariable("id") Long id, TaskModel task) {
        taskService.saveEditTask(task, id);
        return new RedirectView("/tasks");
    }
    @PostMapping("/delete/{id}")
    public RedirectView delTaskById(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return new RedirectView("/tasks");
    }
    @GetMapping("/byColor/{name}")
    public String getColor(@PathVariable String name){
        taskService.findByColor(name);
        return "tasks/editTask";
    }
    // realizujemy to polecenie z Postmana, dlatego dajemy adnotację@PatchMapping
    @PatchMapping("/editDescription/{id}")
    public RedirectView patchDescription(@PathVariable("id")Long id,
                                         @RequestParam String description){
        taskService.updateDescription(id, description);
        return new RedirectView("/tasks");
    }
}
