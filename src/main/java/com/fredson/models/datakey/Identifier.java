package com.fredson.models.datakey;

import java.util.UUID;

public final class Identifier {

    private final String value;

    private Identifier(Entity entity) {
        this.value = entity.key() + ":" + UUID.randomUUID();
    }

    public static Identifier createBy(Entity entity) {
        return new Identifier(entity);
    }

    @Override
    public String toString() {
        return value;
    }
}
