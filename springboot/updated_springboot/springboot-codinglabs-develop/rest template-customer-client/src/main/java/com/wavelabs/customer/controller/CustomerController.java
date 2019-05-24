package com.wavelabs.customer.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.customer.model.Booking;
import com.wavelabs.customer.model.Customer;
import com.wavelabs.customer.model.RequestObject;
import com.wavelabs.customer.repository.CustomerRepo;
import com.wavelabs.customer.service.BookingAdapter;

@RequestMapping(value="/customer")
@RestController
public class CustomerController {
	@Autowired
	CustomerRepo custRepo;

	BookingAdapter ad=new BookingAdapter();
	HashMap<String,Object> mp=new HashMap<String, Object>();

	@RequestMapping(value="/post",method=RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE)
	public void postBookingDetailsByCustomer(@RequestBody RequestObject request) {
		Customer customer= request.getCustomerInfo();
		custRepo.save(customer);
		Booking booking = request.getBookingInfo();
		ad.postBookingDetails(booking);

	}

	@RequestMapping(value="/put",method=RequestMethod.PUT ,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateBookingDetailsByCustomer(@RequestBody RequestObject request) {
		Customer customer= request.getCustomerInfo();
		custRepo.save(customer);
		Booking booking = request.getBookingInfo();
		ad.postBookingDetails(booking);
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/get",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity getBookingDetailsByCustomerId(@RequestParam int id) {
		mp.put("bookinDetails", ad.getBookingDertailsById(id).getBody());
		mp.put("CustomerDetails", custRepo.findById(id));
		return ResponseEntity.status(200).body(mp);

	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public  void deleteCustomerDetailsByCustomerId(@RequestParam int id) {
		ad.deleteBookingDertailsById(id);
		custRepo.deleteById(id);
	}


}
