package io.altar.jseproject.model;

public abstract class Entity {
    protected long id = -1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new RuntimeException("ID inválido. O ID deve ser maior que 0.");
        }
        if (this.id > 0) {
            throw new RuntimeException("O ID já foi definido e não pode ser alterado.");
        }
        this.id = id;
    }}

