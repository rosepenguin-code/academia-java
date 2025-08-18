package io.altar.jseproject.model;

public class Product extends Entity {

    private String nome;
    private double price;
    private int iva;
    private double discount;
    private long shelfId;

    public Product() {}

    public Product(String nome, double price, int iva, double discount, long shelfId) {
        setNome(nome);
        setPrice(price);
        setIva(iva);
        setDiscount(discount);
        this.shelfId = shelfId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("O nome do produto não pode estar vazio.");
        }
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new RuntimeException("O preço deve ser maior que 0.");
        }
        this.price = price;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        if (iva != 6 && iva != 13 && iva != 23) {
            throw new RuntimeException("IVA inválido. Apenas 6%, 13% ou 23% são aceites.");
        }
        this.iva = iva;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 1) {
            throw new RuntimeException("O desconto deve estar entre 0% e 100% (0 a 1).");
        }
        this.discount = discount;
    }

    public long getShelfId() {
        return shelfId;
    }

    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + price + "€, IVA=" + iva + "%, Desconto=" + (discount * 100) + "%, Prateleira=" + shelfId + "]";
    }
}
