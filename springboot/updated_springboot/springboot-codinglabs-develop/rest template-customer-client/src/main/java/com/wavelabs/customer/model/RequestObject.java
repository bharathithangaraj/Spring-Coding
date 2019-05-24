package com.wavelabs.customer.model;

public class RequestObject {
	Customer customerInfo;
	Booking bookingInfo;

	public Customer getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Booking getBookingInfo() {
		return bookingInfo;
	}

	public void setBookingInfo(Booking bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
}
