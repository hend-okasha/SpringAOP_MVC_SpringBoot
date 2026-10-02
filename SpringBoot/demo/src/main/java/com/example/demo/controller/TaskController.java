package com.example.demo.controller;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create( @RequestBody Task task)  {

        Task createdTask = service.createTask(task);
        URI location = URI.create("/api/tasks/" + createdTask.getId());
        return ResponseEntity.created(location).body(createdTask);
    }

    @GetMapping
    public ResponseEntity<Map<Long, Task>> getTasks(@RequestParam (required = false) Boolean completed,
                                                    @RequestParam(required = false) Integer limit){
        if (completed == null){
            Map<Long, Task> tasks= service.getAllTasks(limit);
            return ResponseEntity.ok(tasks);
        }
        return ResponseEntity.ok(service.getCompletedTasks(completed, limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById( @PathVariable Long id ){
        Task task = service.getTaskById(id);
        if (task == null){
            throw new TaskNotFoundException(id);
        }

        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
        Task updated = service.updateTask(id, task);
        if (updated == null){
            throw new TaskNotFoundException(id);
        }
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markCompleted(@PathVariable Long id){
        Task task = service.getTaskById(id);
        if (task == null){
            throw new TaskNotFoundException(id);
        }
        task.setCompleted(true);
        service.updateTask(id, task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id ){
        Task task = service.getTaskById(id);

        if (task == null){
            throw new TaskNotFoundException(id);
        }
        service.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }



}
