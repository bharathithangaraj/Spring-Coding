RESTful Web Services :

                      REST stands for REpresentational State Transfer.

                      REST is an architectural style not a protocol.
                      
                      
Advantages of RESTful Web Services :

                      Fast: RESTful Web Services are fast because there is no strict specification like SOAP. It consumes less bandwidth and resource.

                      Language and Platform independent: RESTful web services can be written in any programming language and executed in any platform.

                      Can use SOAP: RESTful web services can use SOAP web services as the implementation.

                      Permits different data format: RESTful web service permits different data format such as Plain Text, HTML, XML and JSON.
                      
 Request Mapping  :   The @RequestMapping annotation is used to define the Request URI to access the REST End points.
                      We can define Request method to consume and produce object. The default request method is GET.
                 
                 
 PUT API         :    The HTTP PUT request is used to update the existing resource. This method contains a Request Body. 
                      We can send request parameters and path variables to define the custom or dynamic URL.
                      
                      
                      Use the following url in postman :
                      
                      URI : "http://localhost:8080/updateEmployee"
                      
                      
                                        
 @RestController     :      @RestController is a specialized version of the controller. 
                            It includes the @Controller and @ResponseBody annotations.
 