package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import foreisti.model.Board;

public class BoardDao implements Dao<Board>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Board b) {
        sessionFactory.getCurrentSession().save(b);        
    }

    @Override
    public void delete(Board b) {
        sessionFactory.getCurrentSession().delete(b);        
    }

    @Override
    public Board get(Board b) {
        // TODO 
        return null;
    }

    @Override
    public List<Board> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Board> query = sessionFactory.getCurrentSession().createQuery("from Board");
        return query.getResultList();
    }

    @Override
    public void update(Board b) {
        sessionFactory.getCurrentSession().update(b);
    }
    
}