package foreisti.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface Dao<T> {
	@Transactional
	public void save(T t);

	@Transactional
	public void delete(T t);

	@Transactional
	public T get(int id);

	@Transactional
	public T get(String username);

	@Transactional
	public List<T> getAll();

	@Transactional
	public void update(T t);
}
