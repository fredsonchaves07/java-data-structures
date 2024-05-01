package com.fredson.models.datakey;

public abstract class Entity implements Comparable<Entity> {

    private final Identifier identifier;

    public Entity() {
        identifier = Identifier.createBy(this);
    }

    public Identifier id() {
        return identifier;
    }

    public String key() {
        return this.getClass().getSimpleName();
    }
}
