package product.management.web.client;

import product.management.web.data.Product;
import product.management.web.soap.IProductSoapService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ProductClient {
    private static final String REST_URI = "http://localhost:8080/product.management.web/api/products";
    private static final String SOAP_URI = "http://localhost:8080/product.management.web/soap/productservice";

    private Client client = ClientBuilder.newClient();

    public List<Product> getAllProductsRest() {
        WebTarget target = client.target(REST_URI);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        return invocationBuilder.get(new GenericType<List<Product>>(){});
    }

    public IProductSoapService getProductSoapService() throws Exception {
        URL wsdlURL = new URL(SOAP_URI + "?wsdl");
        QName serviceName = new QName("http://soap.web.management.product/", "ProductService");
        Service service = Service.create(wsdlURL, serviceName);
        return service.getPort(IProductSoapService.class);
    }

    // Example usage of the SOAP service
    public Product getProductSoap(int id) throws Exception {
        IProductSoapService service = getProductSoapService();
        return service.getProduct(id);
    }

    // Example usage of the REST service
    public static void main(String[] args) throws Exception {
        ProductClient client = new ProductClient();

        // Get all products using REST
        List<Product> products = client.getAllProductsRest();
        System.out.println("REST: Products retrieved: " + products.size());

        // Get a single product using SOAP
        Product product = client.getProductSoap(1);
        System.out.println("SOAP: Product retrieved: " + product.getName());
    }
}
