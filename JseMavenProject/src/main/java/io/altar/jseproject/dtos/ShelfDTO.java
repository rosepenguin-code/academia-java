package io.altar.jseproject.dtos;

public class ShelfDTO {
	private long id;
    private String localizacao;
    private int capacidade;
    private double precoDiario;
    private Long produtoId; // pode ser null se a shelf estiver vazia
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	public double getPrecoDiario() {
		return precoDiario;
	}
	public void setPrecoDiario(double precoDiario) {
		this.precoDiario = precoDiario;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
