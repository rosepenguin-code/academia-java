package io.altar.jseproject.controllers;

import io.altar.jseproject.business.ShelfManager;
import io.altar.jseproject.dtos.ShelfDTO;
import io.altar.jseproject.model.Shelf;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/shelves")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShelfController {

    @Inject
    private ShelfManager shelfManager;

    @POST
    public Response create(ShelfDTO shelfDTO) {
        Shelf shelf = shelfManager.fromDTO(shelfDTO);
        long id = shelfManager.create(shelf);
        return Response.status(Response.Status.CREATED).entity(id).build();
    }

    @GET
    public List<Shelf> readAll() {
        return shelfManager.readAll();
    }

    @GET
    @Path("/{id}")
    public Response readById(@PathParam("id") long id) {
        Shelf shelf = shelfManager.findById(id);
        if (shelf != null) {
            return Response.ok(shelf).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, ShelfDTO shelfDTO) {
        Shelf shelf = shelfManager.fromDTO(shelfDTO);
        shelf.setId(id); // garante que está a atualizar o shelf correto
        shelfManager.update(shelf);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        shelfManager.delete(id);
        return Response.noContent().build();
    }
}
