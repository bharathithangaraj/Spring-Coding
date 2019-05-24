package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentNegotiationController 
{
	List<Employee> l;
	
/**This method can produce the output in both JSON and XML formats.
 * 
 * 
 * @param employee
 * @return List<Employee>
 */
	
   @RequestMapping(value= "/all")
   public List<Employee> allEmployee(@RequestBody Employee employee) 
   {
	   l = new ArrayList<>();
	   l.add(employee);
	   return l;
   }
   
   
   
   /**This method can produce the output only in  JSON formats.
    * 
    * @param employee
    * @return List<Employee>
    */
   
   @RequestMapping(value= "/json" , produces=MediaType.APPLICATION_JSON_VALUE)
   
   public List<Employee> jsonFormatEmployee(@RequestBody Employee employee) 
   {
	   l = new ArrayList<>();
	   l.add(employee);
	   return l;
   }
   
   
   
   
   
   
   /**This method can produce the output only in XML formats.
    * 
    * @param employee
    * @return List<Employee>
    */
   @RequestMapping(value= "/xml" , produces=MediaType.APPLICATION_XML_VALUE)
   
   public List<Employee> xmlFormatEmployee(@RequestBody Employee employee) 
   {
	   l = new ArrayList<>();
	   l.add(employee);
	   return l;
   }
}
