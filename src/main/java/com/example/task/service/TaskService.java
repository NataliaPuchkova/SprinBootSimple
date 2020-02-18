package com.example.task.service;


import com.example.task.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface TaskService {
    List<Task> getAll(int month, int day);

    List<Task> findAll();

    Task createTask(String text);

    Task createTask1(Task task);

    List<Task> createTasks(List<Task> task);

    Task getById(int id);
}
