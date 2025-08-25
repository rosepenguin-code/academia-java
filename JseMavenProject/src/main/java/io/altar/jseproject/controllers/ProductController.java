package io.altar.jseproject.controllers;

import io.altar.jseproject.business.ProductManager;
import io.altar.jseproject.business.ShelfManager;
import io.altar.jseproject.model.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductManager productManager;

    @Inject
    private ShelfManager shelfManager;

    @GET
    public List<Product> getAll() {
        return productManager.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        try {
            Product product = productManager.findById(id);
            if (product == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Produto não encontrado")
                               .build();
            }
            return Response.ok(product).build();
        } catch (Exception e) {
            // Loga a exceção para debugging
            e.printStackTrace();
            // Retorna erro 500 mas controlado
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Erro ao processar a requisição")
                           .build();
        }
    }


    @POST
    public Response create(Product product) {
        long id = productManager.create(product);
        return Response.status(Response.Status.CREATED).entity("Criado com ID: " + id).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, Product product) {
        product.setId(id);
        Product updated = productManager.update(product);
        return Response.ok("Atualizado com ID: " + updated.getId()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        // Limpa produto das prateleiras antes de apagar
        shelfManager.clearProductFromShelves(id);
        productManager.delete(id);
        return Response.ok("Removido ID: " + id).build();
    }
}
