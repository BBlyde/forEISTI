package foreisti.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import foreisti.model.User;

public class UserDao implements Dao<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User u) {
        sessionFactory.getCurrentSession().save(u);        
    }

    @Override
    public void delete(User u) {
        sessionFactory.getCurrentSession().delete(u);        
    }

    @Override
    public User get(User u) {
        // TODO
    }

    @Override
    public List<User> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void update(User u) {
        sessionFactory.getCurrentSession().update(u);        
    }
    
}
