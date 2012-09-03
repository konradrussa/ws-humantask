package wsht.infrastructure.repository;

import java.util.List;

/**
 * Interface DomainRepository - interfejs repozytorium DB.
 *
 * @param <T> generyczny type reprezentujacy obiekt repozytorium
 */
public interface DomainRepository<T> {

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	void delete(Long id);

	T get(Long id);

	List<T> getAll();
	
	void flush();
	
	/**
	 * Zwraca obiekt repozytorium
	 *
	 * @return klasa modelu repozytorium
	 */
	Class<T> getRepositoryModelClass();

}