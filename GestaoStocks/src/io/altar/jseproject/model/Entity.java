package io.altar.jseproject.model;

public abstract class Entity {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
