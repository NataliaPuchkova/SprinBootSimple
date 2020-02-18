package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{


    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAll(int month, int day) {
        return repository.findByMartchMonthAndMAtchDay(month, day);
    }

    @Override
    public List<Task> findAll() {
        List<Task> list = new ArrayList<Task>();
        list.add((new Task("Something1")));
        list.add((new Task("Something2")).setDate(OffsetDateTime.now().minusDays(1)));
        list.add((new Task("Something3")).setDate(OffsetDateTime.now().minusMonths(1)));
        //return list;
        return repository.findAll();
    }

    @Override
    public Task createTask(String text) {
        return repository.save(new Task(text));
    }

    @Override
    public Task createTask1(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> createTasks(List<Task> tasks) {
        return repository.saveAll(tasks);
    }

    @Override
    public Task getById(int id) {
        return repository.getOne(id);
    }
}
