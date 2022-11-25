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
        TypedQuery<Board> query = entityManager.createQuery("from Board where board_id = :id", Board.class);
		query.setParameter(":id", id);
        return query.getSingleResult();
	}

    @Override
    public Board get(String username) {
        throw new UnsupportedOperationException("Int id needs to be used for Boards");
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