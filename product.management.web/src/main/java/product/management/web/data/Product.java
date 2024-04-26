package product.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int stockQuantity;
    private String sku;

    public Product() {}

    public Product(int id, String name, double price, String description, 
                   String category, int stockQuantity, String sku) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.sku = sku;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", description='" + description + '\'' +
               ", category='" + category + '\'' +
               ", stockQuantity=" + stockQuantity +
               ", sku='" + sku + '\'' +
               '}';
    }
}
