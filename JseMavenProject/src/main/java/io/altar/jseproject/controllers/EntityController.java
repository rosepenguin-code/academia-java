package io.altar.jseproject.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.altar.jseproject.business.EntityManager;
import io.altar.jseproject.model.Entity;

public abstract class EntityController<M extends EntityManager<T>, T extends Entity> {

    protected M repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> getAll() {
        return repository.readAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        Optional<T> entity = repository.readById(id);
        if (entity.isPresent()) {
            return Response.ok(entity.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T entity) {
        long id = repository.create(entity);
        return Response.status(Response.Status.CREATED).entity("Criado com ID: " + id).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, T entity) {
        entity.setId(id);
        repository.update(entity);
        return Response.ok("Atualizado com ID: " + id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        repository.delete(id);
        return Response.ok("Removido ID: " + id).build();
    }
}
