package com.example.TaskPlanner.config;

import com.example.TaskPlanner.models.StatusType;
import com.example.TaskPlanner.models.Task;
import com.example.TaskPlanner.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    final TaskService taskService;

    @Override
    public void run(String... args) throws Exception {

        List<Task> tasks = taskService.getAll();
        if (tasks.isEmpty()){
            Task task1 = Task.builder()
                    .description("learn SQL")
                    .status(StatusType.BACKLOG)
                    .build();
            Task task2 = Task.builder()
                    .description("Practise Spring-Boot")
                    .status(StatusType.DOING)
                    .build();
            Task task3 = Task.builder()
                    .description("Blog-App")
                    .status(StatusType.DONE)
                    .build();

            taskService.save(task1);
            taskService.save(task2);
            taskService.save(task3);
        }

    }
}
