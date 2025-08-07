package io.altar.jseproject.business;



import java.util.List;
import java.util.Optional;

import io.altar.jseproject.model.Entity;

public abstract class EntityManager<T extends Entity> {

	public abstract List<T> readAll();

	public abstract Optional<T> readById(long id);

	public abstract long create(T entity);

	public abstract void update(T entity);

	public abstract void delete(long id); 
	

	

}
