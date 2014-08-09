package com.example.services.impl;

import java.util.Collection;

import org.osgi.service.log.LogService;

import com.example.data.PeopleDao;
import com.example.data.model.Person;
import com.example.services.PeopleService;

public class PeopleServiceImpl implements PeopleService {
	private PeopleDao peopleDao;
	private LogService logService;
	
    @Override
    public Collection< Person > getPeople( final int page, final int pageSize ) {    	   
    	logService.log( LogService.LOG_INFO, "Getting all people" );
        return peopleDao.findAll( page, pageSize );
    }

    @Override
    public Person getByEmail( final String email ) {
    	logService.log( LogService.LOG_INFO, "Looking for a person with e-mail: " + email );
        return peopleDao.find( email );        
    }

    @Override
    public Person addPerson( final String email, final String firstName, final String lastName ) {
    	logService.log( LogService.LOG_INFO, "Adding new person with e-mail: " + email );
        return peopleDao.save( new Person( email, firstName, lastName ) );
    }

    @Override
    public void removePerson( final String email ) {
    	logService.log( LogService.LOG_INFO, "Removing a person with e-mail: " + email );
        peopleDao.delete( email );
    }
    
    public void setPeopleDao( final PeopleDao peopleDao ) {
        this.peopleDao = peopleDao;
    }
    
    public void setLogService( final LogService logService ) {
		this.logService = logService;
	}
}
