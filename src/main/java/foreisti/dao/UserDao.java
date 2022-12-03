package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foreisti.model.User;

@Repository
public class UserDao implements Dao<User> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(User u) {
		entityManager.persist(u);
	}

	@Override
	public void delete(User u) {
		entityManager.remove(u);
	}

	@Override
	public User get(int id) {
		throw new UnsupportedOperationException("String username needs to be used for users");
	}

	@Override
	public User get(String username) {
		TypedQuery<User> query = entityManager.createQuery("from User where username = :username", User.class);
		query.setParameter("username", username);
		List<User> res = query.getResultList();
		return res.isEmpty() ? null : res.get(0);
	}

	@Override
	public List<User> getByColName(String col, String val) {
		TypedQuery<User> query = entityManager.createQuery("from User where " + col + " = :val", User.class);
		query.setParameter("val", val);
		return query.getResultList();
	}

	@Override
	public List<User> getAll() {
		TypedQuery<User> query = entityManager.createQuery("from User", User.class);
		return query.getResultList();
	}

	@Override
	public void update(User u) {
		entityManager.merge(u);
	}
	
}
