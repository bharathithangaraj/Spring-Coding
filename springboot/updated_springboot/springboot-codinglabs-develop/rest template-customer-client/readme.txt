#RESTTemplate

Rest Template is used to create applications that consume RESTful Web Services.
You can use the exchange() method to consume the web services for all HTTP methods.

 RestTemplate restTemplate = new RestTemplate();
 
 is used mainly to create instance of restTemplate in required project
 
 TO MAKE IT CLEAR I HAVE TAKEN EXAMPLE OF 2 CLASSES ONE IS BOOKING AND OTHE ONE IS CUSTOMER
 
 WHERE IAM USING RESTTEMPLATE IN CUSTOMER CLASS 
 
 
 
 
 #GET(to get booking details in customer class)
 
 TO RUN THIS APPLICATION TO DELETE WE SHOULD PASS URL  
		  http://localhost:5007/customer/get?id=2
 
 public ResponseEntity<HashMap> getBookingDertailsById(Integer id){
		  String url="http://localhost:5002/booking/get?id=";
			ResponseEntity<HashMap> exchange =restTemplate.exchange(url+id, HttpMethod.GET,null,HashMap.class);
		return exchange;
		  
	  }
	  
	  
	  
	  
#POST(to post booking details from customer class)

TO RUN THIS APPLICATION TO POST WE SHOULD PASS URL 
http://localhost:5007/customer/post 
along with this we should pass bellow in body
{
	"customerInfo":{
						"custId":2,
						"custName":"hjg",
						"mobileNumber":"1234567890"
					},
	"bookingInfo":{
					"bookingId":3,
					"bookingItem":"mobile2",
					"cost":100000.00
				}
}


public Booking postBookingDetails(Booking booking){
			  String url="http://localhost:5002/booking/post";
			   
				Booking exchange =restTemplate.postForObject(url, booking, Booking.class);
				System.out.println(exchange);
			return exchange;
			  
		  }	 
		  
		  
		   
#DELETE(to post booking details from customer class)
	  
	  TO RUN THIS APPLICATION TO DELETE WE SHOULD PASS URL  
		  http://localhost:5007/customer/delete?id=2
		  
 public void deleteBookingDertailsById(int id){
			  String url="http://localhost:5002/booking/delete?id=";
			  restTemplate.delete(url+id);  
		  }
		  
		  
		  
#UPDATE(to update booking details from customer class)	


TO RUN THIS APPLICATION TO UPDATE WE SHOULD PASS URL 
http://localhost:5007/customer/update 
along with this we should pass bellow in body
{
	"customerInfo":{
						"custId":2,
						"custName":"hjg",
						"mobileNumber":"1234567890"
					},
	"bookingInfo":{
					"bookingId":3,
					"bookingItem":"mobile2",
					"cost":100000.00
				}
}


	  
public Booking updateBookingDertailsById(Booking booking){
			  String url="http://localhost:5002/booking/update";
			  Booking exchange =restTemplate.postForObject(url, booking, Booking.class);			
			return exchange;
			  
		  }	
		  
		  
		  
		  
		  
		  	  