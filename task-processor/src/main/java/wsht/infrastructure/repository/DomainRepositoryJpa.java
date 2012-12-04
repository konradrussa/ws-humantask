package wsht.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


/**
 * Klasa DomainRepositoryJpa - .
 *
 * @param <T> generyczny type reprezentujacy obiekt repozytorium
 */
@Transactional
public abstract class DomainRepositoryJpa<T> implements
		DomainRepository<T> {
	
	/** entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	public abstract Class<T> getRepositoryModelClass();

	public T create(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void delete(Long id) {
		this.delete(this.get(id));
	}

	public T get(Long id) {
		Class<T> modelRepositoryClass = getRepositoryModelClass();
		Object model = entityManager.find(modelRepositoryClass, id);
		return modelRepositoryClass.cast(model);

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return entityManager.createQuery(
				"select o from " + getRepositoryModelClass().getSimpleName() + " o")
				.getResultList();
	}

	public T update(T entity) {
		entity = entityManager.merge(entity);
		return entity;
	}
	
	public void flush() {
		entityManager.flush();
	}
	
	protected Object getNullableSingleResult(Query q) {
	    try {
	        return q.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

	//GETTERS & SETTERS
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

}


