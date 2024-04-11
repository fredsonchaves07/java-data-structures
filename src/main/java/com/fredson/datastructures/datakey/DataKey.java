package com.fredson.datastructures.datakey;

import com.fredson.datastructures.list.List;
import com.fredson.models.datakey.Entity;
import com.fredson.models.datakey.Identifier;

public interface DataKey {

    void createKeys(List<String> keys);

    void createKey(String key);

    Entity get(Identifier identifier);

    Entity get(Entity entity);

    Identifier identifier(Entity entity);

    List<Entity> getValues(String key);

    List<String> getKeys();

    int sizeKey(String key);

    void removeKey(String key);

    void remove(Entity entity);

    void remove(Identifier identifier);

    void put(Entity value);

    void put(Identifier identifier, Entity newEntity);

    void put(Entity oldEntity, Entity newEntity);

    String getDatabaseName();
}
