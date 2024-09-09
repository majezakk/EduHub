package com.example.EduHub.model;

import java.util.UUID;

public class TeacherModel {
    private UUID id;
    private String name;
    private String email;
    private String department;

    public TeacherModel(String name, String email, String department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.department = department;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
