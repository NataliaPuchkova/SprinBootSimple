package com.example.task.repository;

import com.example.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM task " +
            "WHERE extract(MONTH from date) = :m " +
            "AND extract(DAY from date) = :d",
            nativeQuery = true)
    List<Task> findByMartchMonthAndMAtchDay(@Param("m") int month, @Param("d") int day);
}
