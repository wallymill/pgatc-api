Welcome to the Press Ganey Airways Air Traffic Control API!

This project uses a H2 persistent database that is stored in your main USER folder as "pgatcdb".  NOTE:  this can be 
changed from the src/main/resources application.properties file (spring.datasource.url=jdbc:h2:file:~/pgatcdb)

This system will start under the basic embedded Spring Boot Tomcat port:  8080
	- base URI:  http://localhost:8080/pgatc-rest-api
		- boot path:  /boot
		- enqueue path: (ex - /{id}/{model}/{size}
			- /{id} - valid Java Integer
			--------  below values will be case INsensitive
			- /{model} - valid values are "Emergency", "VIP", "Passenger", "Cargo"
			- /{size}  - valid values are "Large" and "Small"
		- dequeue path:
			- /dequeue
		- list path:
			- /list

This system will be inoperable until the /boot endpoint is called.
Once the system is booted, end users can:
	- enqueue a flight by flight number, model and size
	- dequeue the first flight in the queue
	- list the current list of enqueued flights in proper order
	
Happy flying!