package com.example.jaxrs;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.example.data.model.Person;
import com.example.services.PeopleService;

@Path( "/people" )
public class PeopleRestService {
    private PeopleService peopleService;
        
    @Produces( { MediaType.APPLICATION_JSON } )
    @GET
    public Collection< Person > getPeople( @QueryParam( "page") @DefaultValue( "1" ) final int page ) {
        return peopleService.getPeople( page, 5 );
    }

    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{email}" )
    @GET
    public Person getPerson( @PathParam( "email" ) final String email ) {
        return peopleService.getByEmail( email );
    }

    @Produces( { MediaType.APPLICATION_JSON  } )
    @POST
    public Response addPerson( @Context final UriInfo uriInfo,
            @FormParam( "email" ) final String email, 
            @FormParam( "firstName" ) final String firstName, 
            @FormParam( "lastName" ) final String lastName ) {
        
        peopleService.addPerson( email, firstName, lastName );
        return Response.created( uriInfo.getRequestUriBuilder().path( email ).build() ).build();
    }
    
    @Produces( { MediaType.APPLICATION_JSON  } )
    @Path( "/{email}" )
    @PUT
    public Person updatePerson( @PathParam( "email" ) final String email, 
            @FormParam( "firstName" ) final String firstName, 
            @FormParam( "lastName" )  final String lastName ) {
        
        final Person person = peopleService.getByEmail( email );
        
        if( firstName != null ) {
            person.setFirstName( firstName );
        }
        
        if( lastName != null ) {
            person.setLastName( lastName );
        }

        return person;              
    }
    
    @Path( "/{email}" )
    @DELETE
    public Response deletePerson( @PathParam( "email" ) final String email ) {
        peopleService.removePerson( email );
        return Response.ok().build();
    }
    
    public void setPeopleService( final PeopleService peopleService ) {
        this.peopleService = peopleService;
    }
}
