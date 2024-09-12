package com.example.EduHub.model;

import java.util.UUID;

public class CourseModel {
    private UUID id;
    private String name;
    private String description;
    private int hours;

    public CourseModel(String name, String description, int hours) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.hours = hours;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}