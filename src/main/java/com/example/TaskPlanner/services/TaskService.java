package com.example.TaskPlanner.services;

import com.example.TaskPlanner.models.Task;
import com.example.TaskPlanner.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    final TaskRepository taskRepository;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task save(Task newTask){
        if (newTask.getId() == null){
            newTask.setCreatedAt(LocalDateTime.now());
        }
        newTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(newTask);
    }
}
