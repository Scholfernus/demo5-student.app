package com.example.demo5.service;

import com.example.demo5.model.TaskModel;
import com.example.demo5.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveAddTask(TaskModel task) {
        taskRepository.save(task);
    }

//    public void editTask(TaskModel task, Long id) {
//        taskRepository.save(task, id);
//    }
}
