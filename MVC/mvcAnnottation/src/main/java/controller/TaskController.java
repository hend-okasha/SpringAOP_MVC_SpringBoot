package controller;


import exception.TaskNotFoundException;
import jakarta.validation.Valid;
import model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/tasks")
public class TaskController {
    private List<Task> taskList = new ArrayList<>();
    public TaskController(){
        taskList.add(new Task(1, "Learn Spring MVC", "HIGH", false));
        taskList.add(new Task(2, "Practice Servlets", "MEDIUM", true));
        taskList.add(new Task(3, "Build REST API", "HIGH", false));
        taskList.add(new Task(4, "Read Hibernate", "LOW", false));
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTaskById(
            @PathVariable("id") int id,
            Model model) {

        for (Task task : taskList) {

            if (task.getId() == id) {
                model.addAttribute("task", task);
                return "task-details";
            }
        }

        throw new TaskNotFoundException(id);
    }

    @GetMapping("/search")
    public String search(@RequestParam(value ="priority", defaultValue = "LOW") String priority , Model model){
        List<Task> priortyLIst = new ArrayList<>();

        for (Task t: taskList){
            if (t.getPriority().equalsIgnoreCase(priority)){
                priortyLIst.add(t);
            }
        }

        model.addAttribute("tasks" , priortyLIst);
        return "tasks";
    }

    @GetMapping("/new")
    public String createTaskForm( Model model){
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping
    public String createTask(@Valid Task task,
                             BindingResult result){

        if (result.hasErrors()){
            return "task-form";
        }

        int newId = taskList.size()+1;
        task.setId(newId);

        taskList.add(task);
        return "redirect:/tasks";

    }



}
