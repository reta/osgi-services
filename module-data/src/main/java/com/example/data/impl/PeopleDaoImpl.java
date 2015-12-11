package com.example.data.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.example.data.PeopleDao;
import com.example.data.model.Person;

public class PeopleDaoImpl implements PeopleDao {
	@PersistenceContext(unitName = "peopleDb")
	private EntityManager entityManager;
	
	@Override
	public Person save( final Person person ) {
	    entityManager.persist( person );
	    return person;
	}
	
	@Override
	public Person find( final String email ) {
        return entityManager.find( Person.class, email );
    }
	
	public void setEntityManager( final EntityManager entityManager ) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Collection< Person > findAll( final int page, final int pageSize ) {
	    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    
	    final CriteriaQuery< Person > query = cb.createQuery( Person.class );
	    query.from( Person.class );
	    
        return entityManager
                .createQuery( query )
                .setFirstResult(( page - 1 ) * pageSize )
                .setMaxResults( pageSize ) 
                .getResultList();
    }
	
	@Override
	public void delete( final String email ) {
        entityManager.remove( find( email ) );
    }
}
