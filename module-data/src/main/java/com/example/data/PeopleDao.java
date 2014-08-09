package com.example.data;

import java.util.Collection;

import com.example.data.model.Person;

public interface PeopleDao {
	Person save( final Person person );
	Person find( final String email );
	Collection< Person > findAll( final int page, final int pageSize );
	void delete( final String email );	
}
