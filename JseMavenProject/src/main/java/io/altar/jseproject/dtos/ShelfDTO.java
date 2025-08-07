package io.altar.jseproject.dtos;

public class ShelfDTO {
    public long id;
    public String localizacao;
    public int capacidade;
    public double precoDiario;
    public Long produtoId; // pode ser null se a shelf estiver vazia
}
