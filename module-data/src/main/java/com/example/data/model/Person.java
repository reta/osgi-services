package com.example.data.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table( name = "people" )
@Entity
public class Person {
    @Id
    @Column( name = "email", nullable = false, updatable= false )
    private String email;
    
    @Basic
    @Column( name = "firstName", nullable = false, length = 150 )
	private String firstName;
    
    @Basic
    @Column( name = "lastName", nullable = false, length = 150 )
	private String lastName;
		
	protected Person() {
	}
		
	public Person( final String email, final String firstName, final String lastName ) {
	    this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public String getEmail() {
		return email;
	}
	
	protected void setEmail( final String email ) {
		this.email = email;
	}
		
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName( final String firstName ) {
		this.firstName = firstName;
	}
	
	public void setLastName( final String lastName ) {
		this.lastName = lastName;
	}		
}
