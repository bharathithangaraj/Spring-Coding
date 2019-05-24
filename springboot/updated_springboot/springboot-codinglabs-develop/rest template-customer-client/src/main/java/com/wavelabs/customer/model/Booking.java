package com.wavelabs.customer.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Booking
{
	@Id
	private Integer bookingId;
	private String bookingItem;
	private Double cost;
public Integer getBookingId() {
	return bookingId;
}
public String getBookingItem() {
	return bookingItem;
}
public void setBookingItem(String bookingItem) {
	this.bookingItem = bookingItem;
}
public Double getCost() {
	return cost;
}
public void setCost(Double cost) {
	this.cost = cost;
}
public void setBookingId(Integer bookingId) {
	this.bookingId = bookingId;
}

public Booking() {

}

}
