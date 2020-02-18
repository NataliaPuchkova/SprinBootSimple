package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping(value = "/hello")
    public String getHello(){
        return "Hello world!";
    }

    @GetMapping(value = "/all")
    public List<Task> getAllTask(){
        return service.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public Task getTaskById(@PathParam(value = "id") Integer id){
        return service.getById(id);
    }

    @PostMapping(value = "/new1", consumes = "application/json", produces = "application/json")
    public Task createTask1(@RequestBody Task task){
        return service.createTask1(task);
    }

    @PostMapping(value = "/newAll", consumes = "application/json", produces = "application/json")
    public List<Task> createTask1(@RequestBody List<Task> task){
        return service.createTasks(task);
    }
}
