package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foreisti.model.Board;

@Repository
public class BoardDao implements Dao<Board> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Board b) {
		entityManager.persist(b);
	}

	@Override
	public void delete(Board b) {
		entityManager.remove(b);
	}

	@Override
	public Board get(int id) {
		throw new UnsupportedOperationException("String handle needs to be used for Boards");
	}

	@Override
	public Board get(String handle) {
		TypedQuery<Board> query = entityManager.createQuery("from Board where handle = :handle", Board.class);
		query.setParameter("handle", handle);
		List<Board> res = query.getResultList();
		return res.isEmpty() ? null : res.get(0);
	}

	@Override
	public List<Board> getByColName(String col, String val) {
        	TypedQuery<Board> query = entityManager.createQuery("from Board where " + col + " = :val", Board.class);
		query.setParameter("val", val);
        	return query.getResultList();
	}

	@Override
	public List<Board> getAll() {
		TypedQuery<Board> query = entityManager.createQuery("from Board", Board.class);
		return query.getResultList();
	}

	@Override
	public void update(Board b) {
		entityManager.merge(b);
	}
	
}
