package product.management.web.service;

import product.management.web.data.Product;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collection;

public class ProductService {
    private static final ConcurrentHashMap<Integer, Product> products = new ConcurrentHashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger();

    public ProductService() {
        // Initialiser avec quelques produits de test si nécessaire
        initTestData();
    }

    private void initTestData() {
        addProduct(new Product(idCounter.incrementAndGet(), "Laptop", 999.99, "High performance laptop", "Electronics", 50, "LAP1234"));
        addProduct(new Product(idCounter.incrementAndGet(), "Smartphone", 499.99, "Latest model smartphone", "Electronics", 150, "SMART5678"));
    }

    public Product addProduct(Product product) {
        int newId = idCounter.incrementAndGet(); // Assurer un ID unique
        product.setId(newId);
        products.put(newId, product);
        return product;
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        if (products.containsKey(id)) {
            updatedProduct.setId(id);
            products.replace(id, updatedProduct);
            return updatedProduct;
        }
        return null; // ou gérer avec une exception personnalisée
    }

    public Product deleteProduct(int id) {
        return products.remove(id);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}

