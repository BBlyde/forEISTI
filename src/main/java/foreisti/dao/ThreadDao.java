package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foreisti.model.Thread;

@Repository
public class ThreadDao implements Dao<Thread> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Thread t) {
        entityManager.persist(t);        
    }

    @Override
    public void delete(Thread t) {
        entityManager.remove(t);        
    }

	@Override
	public Thread get(int id) {
        TypedQuery<Thread> query = entityManager.createQuery("from Thread where thread_id = :id", Thread.class);
		query.setParameter(":id", id);
        return query.getSingleResult();
	}

    @Override
    public Thread get(String username) {
        throw new UnsupportedOperationException("Int id needs to be used for Threads");
    }

    @Override
    public List<Thread> getAll() {
        TypedQuery<Thread> query = entityManager.createQuery("from Thread", Thread.class);
        return query.getResultList();
    }

    @Override
    public void update(Thread t) {
        entityManager.merge(t);
    }
    
}