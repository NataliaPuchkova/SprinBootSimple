package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Task Controller", description = "Operation with tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping(value = "/hello")
    public String getHello(){
        return "Hello world!";
    }
    @ApiOperation(value = "Returns all list of users.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
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
