package repositories;

import java.util.List;

import javax.persistence.criteria.Predicate;

import entities.BaseModel;
import entities.User;

public interface GenericRepository<T extends BaseModel> {
    
    public void persist(T entity);
    
    public void save(T entity);
    
    public User findById(Long id);
    
    public void remove(T entity);
    
    public List<T> findByPredicate(PredicateBuilder<T> pb);
    
    public T findFirstByPredicate(PredicateBuilder<T> pb);
}
