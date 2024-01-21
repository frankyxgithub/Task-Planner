package com.example.TaskPlanner.controllers;

import com.example.TaskPlanner.models.StatusType;
import com.example.TaskPlanner.models.Task;
import com.example.TaskPlanner.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;

    @PostMapping("/tasks/new")
    public String createTask(@Valid Task newTask){
        newTask.setStatus(StatusType.BACKLOG);
        taskService.save(newTask);
        return "redirect:/";
    }

}
