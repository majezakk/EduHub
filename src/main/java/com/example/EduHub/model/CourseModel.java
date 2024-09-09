package com.example.EduHub.model;

import java.util.UUID;

public class CourseModel {
    private UUID id;
    private String name;
    private String description;
    private int credits;

    public CourseModel(String name, String description, int credits) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    // Геттеры и сеттеры
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
