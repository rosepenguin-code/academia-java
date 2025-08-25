package io.altar.jseproject.model;

import javax.persistence.*;

@Entity
@Table(name = "shelves")
public class Shelf extends Entity_ {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String localizacao;
    private int capacidade;
    private double precoDiario;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Shelf() {}

    public Shelf(String localizacao, int capacidade, double precoDiario, Product product) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoDiario = precoDiario;
        this.product = product;
    }

 
	@Override
    public String toString() {
        return "Prateleira [id=" + id
             + ", localizacao=" + localizacao
             + ", capacidade=" + capacidade
             + ", product=" + (product != null ? product.getId() : null)
             + ", precoDiario=" + precoDiario + "]";
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

	public double getPrecoDiario() {
		return precoDiario;
	}

	public void setPrecoDiario(double precoDiario) {
		this.precoDiario = precoDiario;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
