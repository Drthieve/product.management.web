package product.management.web.soap;

import product.management.web.data.Product;
import product.management.web.service.ProductService;
import javax.jws.WebService;

@WebService(endpointInterface = "product.management.web.soap.IProductSoapService")
public class ProductSoapServiceImpl implements IProductSoapService {
    private ProductService productService = new ProductService();

    @Override
    public Product getProduct(int id) {
        return productService.getProduct(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productService.deleteProduct(id) != null;
    }
}
