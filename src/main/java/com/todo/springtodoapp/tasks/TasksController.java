package com.todo.springtodoapp.tasks;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping(path = "/tasks")
    public Iterable<Task> getAllTasks() {

        return tasksService.findAll();
    }

    @PostMapping(path = "/tasks", produces = "application/json")
    public Task saveTask(@RequestParam String title, @RequestParam String desc) {

        return tasksService.save(title, desc);

    }

    @PutMapping(path = "/tasks", produces = "application/json")
    public Task putTask(@RequestParam Integer id, @RequestParam String title, @RequestParam String desc) {

        return tasksService.put(id, title, desc);
    }

    @DeleteMapping(path = "/tasks")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@RequestParam Integer id) {

        tasksService.delete(id);
    }

}
