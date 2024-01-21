package com.example.TaskPlanner.controllers;

import com.example.TaskPlanner.models.StatusType;
import com.example.TaskPlanner.models.Task;
import com.example.TaskPlanner.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;

    @PutMapping("/tasks/{id}")
    public Task updateTaskItem(@PathVariable("id") long id) {
        Task updatedTask = taskService.getById(id);
        if (updatedTask.getStatus() == StatusType.BACKLOG) {
            updatedTask.setStatus(StatusType.IN_PROGRESS);
        } else if (updatedTask.getStatus() == StatusType.IN_PROGRESS) {
            updatedTask.setStatus(StatusType.DONE);
        }

        return taskService.save(updatedTask);
    }

}
