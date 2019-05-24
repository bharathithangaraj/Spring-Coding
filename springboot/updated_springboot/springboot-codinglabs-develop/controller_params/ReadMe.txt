Spring @PathVariable :
@RequestMapping with @PathVariable: RequestMapping annotation can be used to handle dynamic URIs where one or more of the URI value works as a parameter. 
                                    We can even specify Regular Expression for URI dynamic parameter to accept only specific type of input.
                                    It works with @PathVariable annotation through which we can map the URI variable to one of the method arguments. 
                                    
                                    
                 Example : 
                public ResponseEntity<Object> updateProduct(@PathVariable("id") String id)
                {
                                       
                 }
                                  
Spring @RequestParam :

@RequestMapping with @RequestParam for URL parameters: Sometimes we get parameters in the request URL, mostly in GET requests.
                                                       We can use @RequestMapping with @RequestParam annotation to retrieve the URL parameter and map it to the method argument.
                                                       
                          Example:
                          For this method to work, the parameter name should be “id” and it should be of type int.
                                       
                public ResponseEntity<Object> getProduct(@RequestParam(value = "name", required = false, defaultValue = "honey") String name)
                {
                                        
                }
                                       
                                       
 @RestController     :   @RestController is a specialized version of the controller. 
                         It includes the @Controller and @ResponseBody annotations.