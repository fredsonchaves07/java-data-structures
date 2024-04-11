package com.fredson.datastructures.datakey;

import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.datastructures.map.HashMap;
import com.fredson.datastructures.map.Map;
import com.fredson.models.KeyValue;
import com.fredson.models.datakey.Entity;
import com.fredson.models.datakey.Identifier;


public class DataStore implements DataKey {

    private final String databaseName;

    private final HashMap<String, Map<Identifier, Entity>> dataKey = new HashMap<>();

    public DataStore(String name) {
        this.databaseName = name;
    }

    @Override
    public void createKeys(List<String> keys) {
        List<String> listKeys = keys.clone();
        while (listKeys.iterator().hasNext()) {
            String next = listKeys.iterator().next();
            dataKey.set(next, new HashMap<>());
        }
    }

    @Override
    public void createKey(String key) {
        if (!dataKey.hasKey(key)) dataKey.set(key, new HashMap<>());
    }

    @Override
    public Entity get(Identifier identifier) {
        String key = identifier.toString().split(":")[0];
        if (dataKey.hasKey(key)) return dataKey.get(key).get(identifier);
        return null;
    }

    @Override
    public Entity get(Entity entity) {
        if (dataKey.hasKey(entity.key())) return dataKey.get(entity.key()).get(entity.id());
        return null;
    }


    @Override
    public Identifier identifier(Entity entity) {
        if (dataKey.hasKey(entity.key())) {
            List<KeyValue<Identifier, Entity>> keyValueList = dataKey.get(entity.key()).keysValues();
            while (keyValueList.iterator().hasNext()) {
                KeyValue<Identifier, Entity> next = keyValueList.iterator().next();
                if (next.value().equals(entity)) return next.key();
            }
        }
        return null;
    }

    @Override
    public List<Entity> getValues(String key) {
        List<Entity> list = new ArrayList<>();
        if (dataKey.isEmpty()) return list;
        if (!dataKey.hasKey(key)) return list;
        List<Entity> values = dataKey.get(key).values();
        while (values.iterator().hasNext()) list.push(values.iterator().next());
        return list;
    }

    @Override
    public List<String> getKeys() {
        List<String> list = new ArrayList<>();
        if (dataKey.isEmpty()) return list;
        List<KeyValue<String, Map<Identifier, Entity>>> keyValueList = dataKey.keysValues();
        while (keyValueList.iterator().hasNext()) {
            String key = keyValueList.iterator().next().key();
            list.push(key);
        }
        return list;
    }

    @Override
    public int sizeKey(String key) {
        if (dataKey.hasKey(key)) dataKey.get(key).length();
        return 0;
    }

    @Override
    public void removeKey(String key) {
        if (dataKey.hasKey(key)) dataKey.remove(key);
    }

    @Override
    public void remove(Entity entity) {
        if (dataKey.hasKey(entity.key())) dataKey.get(entity.key()).remove(entity.id());
    }

    @Override
    public void remove(Identifier identifier) {
        String key = identifier.toString().split(":")[0];
        if (dataKey.hasKey(key)) dataKey.get(key).remove(identifier);
    }

    @Override
    public void put(Entity entity) {
        if (!dataKey.hasKey(entity.key())) createKey(entity.key());
        dataKey.get(entity.key()).set(entity.id(), entity);
    }

    @Override
    public void put(Identifier identifier, Entity newEntity) {
        String oldKey = identifier.toString().split(":")[0];
        String newKey = newEntity.key();
        if (oldKey.equals(newKey) && dataKey.hasKey(oldKey)) {
            remove(identifier);
            put(newEntity);
        }
    }

    @Override
    public void put(Entity oldEntity, Entity newEntity) {
        String oldKey = oldEntity.key();
        String newKey = newEntity.key();
        if (oldKey.equals(newKey) && dataKey.hasKey(oldKey)) {
            remove(oldEntity);
            put(newEntity);
        }
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public String toString() {
        return "{Database: " + getDatabaseName() + ", Keys: " + getKeys() + ", Size: " + getKeys().length() + "}";
    }
}
