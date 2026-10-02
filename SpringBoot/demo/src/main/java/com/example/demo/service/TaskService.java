package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.Map;

public interface TaskService {
    Task createTask(Task task) ;
    Map<Long, Task> getAllTasks(Integer limit);
    Map<Long, Task> getCompletedTasks(boolean completed, Integer limit);
    Task getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTaskById( Long id);
}
