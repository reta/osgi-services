# Sample OSGi application using Apache CXF and OpenJPA

## In Karaf 3.0.1 shell
feature:repo-add cxf 3.0.1

feature:install http cxf jpa openjpa transaction jndi jdbc

install -s mvn:org.hsqldb/hsqldb/2.3.2

install -s mvn:com.fasterxml.jackson.core/jackson-core/2.4.0
install -s mvn:com.fasterxml.jackson.core/jackson-annotations/2.4.0
install -s mvn:com.fasterxml.jackson.core/jackson-databind/2.4.0
install -s mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-base/2.4.0
install -s mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-json-provider/2.4.0
	
## From command line
 - Create new person: 	
   curl http://localhost:8181/cxf/api/people -i -X POST -d "firstName=Tom&lastName=Knocker&email=a@b.com"   
 - Query for person by e-mail:
   curl http://localhost:8181/cxf/api/people/a@b.com
 - Query all people:
   curl http://localhost:8181/cxf/api/people
 - Delete person by e-mail:
   curl http://localhost:8181/cxf/api/people/a@b.com -X DELETE
