package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/id/{id}")
    public Task getTaskById(@PathVariable(value = "id") Integer id){
        System.out.println("id="+id);
        return service.getById(id);
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public Task createTask1(@RequestBody Task task){
        return service.createTask1(task);
    }

    @PostMapping(value = "/newAll", consumes = "application/json", produces = "application/json")
    public List<Task> createTask1(@RequestBody List<Task> task){
        return service.createTasks(task);
    }

    @PostMapping(value = "/newAll2", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Task>> createTask2(@RequestBody List<Task> task){
        return ResponseEntity.ok(service.createTasks(task));
    }
}
