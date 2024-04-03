package entities;

public class Product {
    private String name;
    private Double priceProduct;

    public Product() {
    }

    public Product(String name, Double priceProduct) {
        this.name = name;
        this.priceProduct = priceProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }
}
