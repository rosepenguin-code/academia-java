package io.altar.jseproject.model;

public class Shelf extends Entity {
    private String localizacao;
    private int capacidade;
    private long productId; // Agora guarda apenas o ID do produto
    private double precoDiario;

    public Shelf() {}

    public Shelf(String localizacao, int capacidade, double precoDiario, long productId) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoDiario = precoDiario;
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    @Override
    public String toString() {
        return "Prateleira [id=" + id
             + ", localizacao=" + localizacao
             + ", capacidade=" + capacidade
             + ", productId=" + productId
             + ", precoDiario=" + precoDiario + "]";
    }
}
