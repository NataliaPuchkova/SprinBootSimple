package com.example.task.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name="task")
public class Task {
    public int getId() {
        return id;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date", nullable = false)
    private OffsetDateTime date;

    @Column(name="text", nullable = true)
    private String text;

    public OffsetDateTime getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Task() {
    }

    public Task(String text) {
        this.text = text;
        this.date = OffsetDateTime.now();
    }

    public Task setDate(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    public Task setText(String text) {
        this.text = text;
        return this;
    }
}
