package io.altar.jseproject.controllers;

import io.altar.jseproject.business.ProductManager;
import io.altar.jseproject.dtos.ProductDTO;
import io.altar.jseproject.model.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductManager manager;

    @GET
    public List<ProductDTO> getAll() {
        return manager.readAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        return manager.readById(id)
                .map(product -> Response.ok(toDTO(product)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(ProductDTO dto) {
        Product p = fromDTO(dto);
        long id = manager.create(p);
        return Response.status(Response.Status.CREATED).entity("Criado com ID: " + id).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, ProductDTO dto) {
        Product p = fromDTO(dto);
        p.setId(id);
        manager.update(p);
        return Response.ok("Atualizado com ID: " + id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        manager.delete(id);
        return Response.ok("Removido ID: " + id).build();
    }

    private ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.id = p.getId();
        dto.nome = p.getNome();
        dto.preco = p.getPreco();
        dto.temIVA = p.isTemIVA();
        dto.discount = p.getDiscount();
        dto.isPromotion = p.isPromotion();
        return dto;
    }

    private Product fromDTO(ProductDTO dto) {
        Product p = new Product(dto.nome, dto.preco, dto.temIVA);
        p.setDiscount(dto.discount);
        p.setPromotion(dto.isPromotion);
        return p;
    }
}
