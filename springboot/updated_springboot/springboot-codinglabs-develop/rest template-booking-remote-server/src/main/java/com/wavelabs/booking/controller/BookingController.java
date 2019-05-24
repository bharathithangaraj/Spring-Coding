package com.wavelabs.booking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.booking.model.Booking;
import com.wavelabs.booking.repository.BookingRepo;
@RequestMapping(value="/booking")
@RestController
public class BookingController 
{
	@Autowired
	BookingRepo bookingRepo;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Optional<Booking> getBookingDetailsByCustomerId(@RequestParam Integer id) {
		return bookingRepo.findById(id);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/post",method=RequestMethod.POST)
	public ResponseEntity postBookingDetailsByCustomer(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseEntity updateBookingDetailsByCustomer(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public ResponseEntity deleteBookingDetailsByCustomerId(@RequestParam Integer id) {
		bookingRepo.deleteById(id);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
