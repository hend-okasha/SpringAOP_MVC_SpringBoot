package com.example.demo.repo;

import com.example.demo.model.Task;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

public interface TaskRepository {
    Task save(Task task);
    Map<Long, Task> findAll();
    Map<Long, Task> findByCompleted(boolean completed);
    Task findById(Long id);
    void deleteById(Long id);
    long count();

}
