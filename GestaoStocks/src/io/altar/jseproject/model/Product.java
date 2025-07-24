package io.altar.jseproject.model;

public class Product extends Entity {
    private String nome;
    private double preco;
    private boolean temIVA;

    public Product(String nome, double preco, boolean temIVA) {
        this.nome = nome;
        this.preco = preco;
        this.temIVA = temIVA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isTemIVA() {
        return temIVA;
    }

    public void setTemIVA(boolean temIVA) {
        this.temIVA = temIVA;
    }

    
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", IVA=" + temIVA + "]";
    }
}
