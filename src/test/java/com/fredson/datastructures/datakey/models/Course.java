package com.fredson.datastructures.datakey.models;

import com.fredson.models.datakey.Entity;

public class Course extends Entity {

    private final String name;

    private final String departament;

    public Course(String name, String departament) {
        this.name = name;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public String getDepartament() {
        return departament;
    }

    @Override
    public int compareTo(Entity o) {
        if (o == null) return - 1;
        return this.id().toString().compareTo(o.id().toString());
    }
}
