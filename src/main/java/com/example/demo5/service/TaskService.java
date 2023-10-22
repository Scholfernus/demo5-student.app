package com.example.demo5.service;

import com.example.demo5.model.TaskModel;
import com.example.demo5.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public TaskModel getTaskById(Long id)  {
        return taskRepository.findById(id).orElse(null);
    }

    public void saveEditTask(TaskModel task, Long id) {
        task.setId(id);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public List<TaskModel>findByColor(String name){
        List<TaskModel> color = taskRepository.findByColor(name);
    log.info("color {}", color);
    return color;
    }
    public void updateDescription(Long id, String description){
        taskRepository.updateDescriptionById(id, description);
    }
}
