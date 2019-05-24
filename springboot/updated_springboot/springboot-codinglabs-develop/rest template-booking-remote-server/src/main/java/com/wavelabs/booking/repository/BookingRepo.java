package com.wavelabs.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.booking.model.Booking;


public interface BookingRepo extends JpaRepository<Booking, Integer>
{

	
	
}
