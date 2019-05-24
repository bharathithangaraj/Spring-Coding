Asynchronous In Spring Boot:

           1.In order to execute your function in another thread, all you have to do is to annotate your functions with the @Async annotation.
           2.Just using the @Async annotation is not enough. We need to enable Spring’s asynchronous method execution capability by using the @EnableAsync annotation in one of our configuration classes.


In this example 
                 There are 3 methods in AsyncService.java which are annotated with @Async.
                 we are calling the 3 methods from the controller.
                 which will run parallely.
                 you can observe the things when method Started and Stopped.


