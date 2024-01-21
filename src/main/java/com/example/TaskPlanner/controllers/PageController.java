package com.example.TaskPlanner.controllers;

import com.example.TaskPlanner.models.StatusType;
import com.example.TaskPlanner.models.Task;
import com.example.TaskPlanner.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PageController {
    final TaskService taskService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newTask", new Task());

        modelAndView.addObject("backlog", taskService.getAllByStatus(StatusType.BACKLOG));
        modelAndView.addObject("in_progress", taskService.getAllByStatus(StatusType.IN_PROGRESS));
        modelAndView.addObject("done", taskService.getAllByStatus(StatusType.DONE));

        return modelAndView;
    }
}
