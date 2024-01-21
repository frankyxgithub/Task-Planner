package com.example.TaskPlanner.repositories;

import com.example.TaskPlanner.models.StatusType;
import com.example.TaskPlanner.models.Task;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Long> {
    List<Task> findByStatus(StatusType status);
}
