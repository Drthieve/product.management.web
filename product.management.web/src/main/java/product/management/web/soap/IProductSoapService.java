package product.management.web.soap;

import product.management.web.data.Product;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService
public interface IProductSoapService {
    @WebMethod
    Product getProduct(@WebParam(name = "id") int id);

    @WebMethod
    Product addProduct(@WebParam(name = "product") Product product);

    @WebMethod
    boolean deleteProduct(@WebParam(name = "id") int id);
}
