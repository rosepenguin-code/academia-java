package io.altar.jseproject.model;

public class Product extends Entity {
	private String nome;
	private double preco;
	private boolean temIVA;
	private double discount; // Valor entre 0.0 e 1.0
	
	
	public Product() {}

	// Construtor
	public Product(String nome, double preco, boolean temIVA) {
		this.nome = nome;
		this.preco = preco;
		this.temIVA = temIVA;
		this.discount = 0.0;
	}

	// Getters e Setters
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		if (discount < 0.0 || discount > 1.0) {
			throw new RuntimeException("Desconto inválido: deve estar entre 0.0 e 1.0");
		}
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Produto [ID=" + getId()
			 + ", Nome=" + nome
			 + ", Preço=" + preco
			 + ", Tem IVA=" + temIVA
			 + ", Desconto=" + (discount * 100) + "%]";
	}
}
