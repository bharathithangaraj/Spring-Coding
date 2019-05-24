Spring Boot:  Spring Boot offers a fast way to build applications. It looks at your class path and at beans you have configured, makes reasonable assumptions about what you’re missing, and adds it. 
              With Spring Boot you can focus more on business features and less on infrastructure.Spring Boot doesn’t generate code or make edits to your files. Instead, when you start up your application, Spring Boot dynamically wires up beans and settings and applies them to your application context.


              This application simply returns our message on Browser and Postman also, by using the 
              
              URI : "http://localhost:8080/message"

             
Rest Controller: The @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response. Its syntax is shown below −

                   Example :
                   @RestController
                   public class ProductServiceController 
                   {
                  
                   }