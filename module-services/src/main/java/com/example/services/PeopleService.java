package com.example.services;

import java.util.Collection;

import com.example.data.model.Person;

public interface PeopleService {
    Collection< Person > getPeople( int page, int pageSize );
    Person getByEmail( final String email );
    Person addPerson( final String email, final String firstName, final String lastName );
    void removePerson( final String email );
}
