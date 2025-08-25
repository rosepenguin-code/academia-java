package io.altar.jseproject.dtos;

public class ProductDTO {
    private long id;
    private String nome;
    private double preco;
    private boolean temIVA;
    private double discount;
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isTemIVA() {
		return temIVA;
	}
	public void setTemIVA(boolean temIVA) {
		this.temIVA = temIVA;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
