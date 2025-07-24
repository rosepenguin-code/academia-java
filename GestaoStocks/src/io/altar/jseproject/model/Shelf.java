package io.altar.jseproject.model;

public class Shelf extends Entity {
    private String localizacao;
    private int capacidade;
    private Product produto; // Apenas um tipo de produto
    private double precoDiario;

    public Shelf(String localizacao, int capacidade, double precoDiario) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoDiario = precoDiario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    @Override
    public String toString() {
        String nomeProduto = (produto != null) ? produto.getNome() : "Nenhum";
        return "Prateleira [id=" + id
             + ", localizacao=" + localizacao
             + ", capacidade=" + capacidade
             + ", produto=" + nomeProduto
             + ", precoDiario=" + precoDiario + "]";
    }
}
