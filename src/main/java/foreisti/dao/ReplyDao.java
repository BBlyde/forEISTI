package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foreisti.model.Reply;

@Repository
public class ReplyDao implements Dao<Reply> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Reply r) {
		entityManager.persist(r);
	}

	@Override
	public void delete(Reply r) {
		entityManager.remove(r);
	}

	@Override
	public Reply get(int id) {
		TypedQuery<Reply> query = entityManager.createQuery("from Reply where post_id = :id", Reply.class);
		query.setParameter("id", id);
		List<Reply> res = query.getResultList();
		return res.isEmpty() ? null : res.get(0);
	}

	@Override
	public Reply get(String id) {
		throw new UnsupportedOperationException("Int id needs to be used for Replys");
	}

	@Override
	public List<Reply> getByColName(String col, String val) {
		TypedQuery<Reply> query = entityManager.createQuery("from Reply where " + col + " = :val", Reply.class);
		query.setParameter("val", val);
		return query.getResultList();
	}

	@Override
	public List<Reply> getAll() {
		TypedQuery<Reply> query = entityManager.createQuery("from Reply", Reply.class);
		return query.getResultList();
	}

	@Override
	public void update(Reply r) {
		entityManager.merge(r);
	}
	
}
