package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foreisti.model.Category;

@Repository
public class CategoryDao implements Dao<Category> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Category c) {
        entityManager.persist(c);        
    }

    @Override
    public void delete(Category c) {
        entityManager.remove(c);        
    }

	@Override
	public Category get(int id) {
        TypedQuery<Category> query = entityManager.createQuery("from Category where cat_id = :id", Category.class);
		query.setParameter("id", id);
        List<Category> res = query.getResultList();
		return res.isEmpty() ? null : res.get(0);
	}

    @Override
    public Category get(String username) {
        throw new UnsupportedOperationException("Int id needs to be used for Categorys");
    }

    @Override
    public List<Category> getAll() {
        TypedQuery<Category> query = entityManager.createQuery("from Category", Category.class);
        return query.getResultList();
    }

    @Override
    public void update(Category c) {
        entityManager.merge(c);
    }
    
}
