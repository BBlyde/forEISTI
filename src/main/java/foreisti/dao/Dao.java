package foreisti.dao;

import java.util.List;

public interface Dao<T> {
	public void save(T t);

	public void delete(T t);

	public T get(T t);

	public List<T> getAll();

	public void update(T t);
}
