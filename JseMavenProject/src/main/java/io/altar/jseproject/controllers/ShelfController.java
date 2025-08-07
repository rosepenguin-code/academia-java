package io.altar.jseproject.controllers;

import io.altar.jseproject.business.ShelfManager;
import io.altar.jseproject.dtos.ShelfDTO;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/shelves")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShelfController {

    @Inject
    ShelfManager manager;

    @GET
    public List<ShelfDTO> getAll() {
        return manager.readAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        return manager.readById(id)
                .map(shelf -> Response.ok(toDTO(shelf)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(ShelfDTO dto) {
        Shelf s = fromDTO(dto);
        long id = manager.create(s);
        return Response.status(Response.Status.CREATED).entity("Criado com ID: " + id).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, ShelfDTO dto) {
        Shelf s = fromDTO(dto);
        s.setId(id);
        manager.update(s);
        return Response.ok("Atualizado com ID: " + id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        manager.delete(id);
        return Response.ok("Removido ID: " + id).build();
    }

    private ShelfDTO toDTO(Shelf s) {
        ShelfDTO dto = new ShelfDTO();
        dto.id = s.getId();
        dto.localizacao = s.getLocalizacao();
        dto.capacidade = s.getCapacidade();
        dto.precoDiario = s.getPrecoDiario();
        dto.productId = s.getProduto() != null ? s.getProduto().getId() : null;
        return dto;
    }

    private Shelf fromDTO(ShelfDTO dto) {
        Shelf s = new Shelf(dto.localizacao, dto.capacidade, dto.precoDiario);
        if (dto.productId != null && dto.productId > 0) {
            Product p = new Product();
            p.setId(dto.productId);
            s.setProduto(p);
        }
        return s;
    }
}
