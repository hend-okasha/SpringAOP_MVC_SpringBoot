package com.example.demo.repo;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private Map<Long, Task> taskList = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Task save(Task task) {
        if (task.getId() == null ){
            task.setId(idGenerator.incrementAndGet());
        }
        taskList.put(task.getId(),task);
        return task;
    }

    @Override
    public Map<Long, Task> findAll() {
        return taskList ;
    }

    @Override
    public Map<Long, Task> findByCompleted(boolean completed) {
        Map<Long, Task> completedTasks = new HashMap<>();
        for (Map.Entry<Long , Task> entry : taskList.entrySet()){
            if(entry.getValue().isCompleted() == completed){
                completedTasks.put(entry.getKey(), entry.getValue());
            }
        }
        return completedTasks;
    }

    @Override
    public Task findById(Long id) {
        return taskList.get(id);
    }

    @Override
    public void deleteById(Long id) {
        taskList.remove(id);
    }

    @Override
    public long count() {
        return taskList.size() ;
    }
}
