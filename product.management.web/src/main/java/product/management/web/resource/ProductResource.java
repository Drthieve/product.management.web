package product.management.web.resource;

import product.management.web.data.Product;
import product.management.web.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ArrayList;

@Path("/products")
public class ProductResource {
    private final ProductService productService = new ProductService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Product> productList = new ArrayList<>(productService.getAllProducts());
        return Response.ok(productList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        Product newProduct = productService.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(newProduct).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") int id) {
        Product product = productService.deleteProduct(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }
}
