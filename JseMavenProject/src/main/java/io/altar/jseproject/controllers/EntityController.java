package io.altar.jseproject.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.altar.jseproject.business.EntityService;
import io.altar.jseproject.model.Entity_;

public abstract class EntityController<M extends EntityService<?, T>, T extends Entity_> {

    protected final M manager;

    public EntityController(M manager) {
        this.manager = manager;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> getAll() {
        return manager.readAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        Optional<T> entity = manager.readById(id);
        return entity.map(value -> Response.ok(value).build())
                     .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T entity) {
        long id = manager.create(entity);
        return Response.status(Response.Status.CREATED).entity("Criado com ID: " + id).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, T entity) {
        entity.setId(id);
        manager.update(entity);
        return Response.ok("Atualizado com ID: " + id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        manager.delete(id);
        return Response.ok("Removido ID: " + id).build();
    }
}

