package com.fredson.datastructures.datakey.models;

import com.fredson.models.datakey.Entity;

public class Student extends Entity {

    private String name;

    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Entity o) {
        if (o == null) return - 1;
        return this.id().toString().compareTo(o.id().toString());
    }
}
