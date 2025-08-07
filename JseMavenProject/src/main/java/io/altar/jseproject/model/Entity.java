package io.altar.jseproject.model;

public abstract class Entity {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id; // Deixa o controlo ao Repository
    }
}
