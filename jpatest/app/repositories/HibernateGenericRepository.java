package repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;

import entities.BaseModel;
import entities.User;
import play.db.jpa.JPAApi;



public class HibernateGenericRepository<T extends BaseModel> implements GenericRepository<T> {

	private JPAApi api;

	private Class<T> persistentClass;

	@Inject
	@SuppressWarnings("unchecked")
	public HibernateGenericRepository(TypeLiteral<T> type, JPAApi api) {
		this.persistentClass = (Class<T>) type.getRawType();
		this.api = api;
	}
	

	

	@Override
	public void persist(T entity) {
		api.withTransaction(entityManager -> {
			entityManager.persist(entity);
			return entity;
		});
	}
	
	@Override
	public void save(T entity) {
		api.withTransaction(entityManager -> {
			entityManager.merge(entity);
			return entity;
		});
		
	}

	@Override
	public void remove(T entity) {
		api.withTransaction(entityManager -> {
			entityManager.remove(entity);
			return entity;
		});
	}




	@Override
	public User findById(Long id) {
		return (User) api.withTransaction(entityManager -> {
			return entityManager.find(persistentClass, id);
		});
		
	}
	
	@Override
	public List<T> findByPredicate(PredicateBuilder<T> pb) {
		return api.withTransaction(entityManager -> {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		    CriteriaQuery<T> q = cb.createQuery(persistentClass);
		    Root<T> root = q.from(persistentClass);
		    ParameterExpression<Integer> p = cb.parameter(Integer.class);
		    CriteriaQuery<T> criteriaQuery = q.select(root);
		    criteriaQuery.where(pb.build(cb, root));
		    TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
		    return typedQuery.getResultList();
		});
	}




	@Override
	public T findFirstByPredicate(PredicateBuilder<T> pb) {
		return api.withTransaction(entityManager -> {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		    CriteriaQuery<T> q = cb.createQuery(persistentClass);
		    Root<T> root = q.from(persistentClass);
		    ParameterExpression<Integer> p = cb.parameter(Integer.class);
		    CriteriaQuery<T> criteriaQuery = q.select(root);
		    criteriaQuery.where(pb.build(cb, root));
		    TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
		    if(typedQuery.getResultList().size()>0) {
		    	return typedQuery.getResultList().get(0);
		    }else{
		    	return null;
		    }
		    
		});
	}




	

}
