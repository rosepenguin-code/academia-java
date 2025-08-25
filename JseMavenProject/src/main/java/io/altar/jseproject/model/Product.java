package io.altar.jseproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends Entity_ {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private double preco;
    private boolean temIVA;
    private double discount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shelf> shelves = new ArrayList<>();

    public Product() {}

    public Product(String nome, double preco, boolean temIVA) {
        this.nome = nome;
        this.preco = preco;
        this.temIVA = temIVA;
        this.discount = 0.0;
    }

    // getters e setters

    @Override
    public String toString() {
        return "Produto [ID=" + getId()
             + ", Nome=" + nome
             + ", Preço=" + preco
             + ", Tem IVA=" + temIVA
             + ", Desconto=" + (discount * 100) + "%]";
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
	    if (discount < 0 || discount > 1) { // porque no teste uso 0.25 para 25%
	        throw new RuntimeException("O desconto tem de estar entre 0% e 100% (0.0 a 1.0).");
	    }
	    this.discount = discount;
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public boolean isTemIVA() {
		return temIVA;
	}

	public void setTemIVA(boolean temIVA) {
		this.temIVA = temIVA;
	}

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
