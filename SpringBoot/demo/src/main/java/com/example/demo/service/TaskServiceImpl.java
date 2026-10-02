package com.example.demo.service;

import com.example.demo.exception.InvalidLimitException;
import com.example.demo.exception.InvalidTaskException;
import com.example.demo.exception.MaxTasksReachedException;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class TaskServiceImpl implements TaskService{

    @Value("${demotasktracker.max-tasks}")
    private int maxTasks;

    @Value("${demotasktracker.default-page-size}")
    private int defaultPageSize;

    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    private static final Logger logger =
            LoggerFactory.getLogger(TaskServiceImpl.class);

    @Override
    public Task createTask(Task task)  {
        logger.info("Start create task with id : " + task.getId() );
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new InvalidTaskException("Task title is required");
        }
        if (taskRepository.count() >= maxTasks) {
            throw new MaxTasksReachedException("Maximum number of tasks reached");
        }
        taskRepository.save(task);

        logger.debug("logger debug: ");
        return task;
    }

    @Override
    public Map<Long, Task> getAllTasks(Integer limit) {
        int effectiveLimit;
        if (limit != null) {
            if (limit <= 0) {
                throw new InvalidLimitException("Limit must be greater than zero");
            }
            effectiveLimit = limit;
        } else {
            effectiveLimit = defaultPageSize;
        }        Map<Long, Task> all = taskRepository.findAll();

        Map<Long, Task> result = new HashMap<>();
        int count = 0;
        for (Map.Entry<Long, Task> entry : all.entrySet()) {
            if (count >= effectiveLimit) break;
            result.put(entry.getKey(), entry.getValue());
            count++;
        }
        return result;
    }

    @Override
    public Map<Long, Task> getCompletedTasks(boolean completed, Integer limit) {
        int effectiveLimit;

        if (limit != null) {
            if (limit <= 0) {
                throw new InvalidLimitException("Limit must be greater than zero");
            }
            effectiveLimit = limit;
        } else {
            effectiveLimit = defaultPageSize;
        }
        Map<Long, Task> all = taskRepository.findByCompleted(completed);
        Map<Long, Task> result = new HashMap<>();

        int count = 0;
        for (Map.Entry<Long, Task> entry : all.entrySet()) {
            if (count >= effectiveLimit) {
                break;
            }
            result.put(entry.getKey(), entry.getValue());
            count++;
        }
        return result;
    }

    @Override
    public Task getTaskById(Long id) {
        Task task = taskRepository.findById(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new InvalidTaskException("Task title is required");
        }
        Task existing = taskRepository.findById(id);
        if (existing == null){
            throw new TaskNotFoundException(id);
        }
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setCompleted(task.isCompleted());
        existing.setDueDate(task.getDueDate());
        taskRepository.save(existing);
        return existing;
    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
