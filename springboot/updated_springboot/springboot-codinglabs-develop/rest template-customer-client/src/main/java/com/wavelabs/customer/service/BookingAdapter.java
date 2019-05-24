package com.wavelabs.customer.service;


import com.wavelabs.customer.model.Booking;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

@Component
public class BookingAdapter {
  RestTemplate restTemplate = new RestTemplate();

  @Retryable(value = {Exception.class}, maxAttempts = 4, backoff = @Backoff(2000))
  public ResponseEntity<HashMap> getBookingDertailsById(Integer id) {
    String url = "http://localhost:5002/booking/get?id=";
    ResponseEntity<HashMap> exchange = restTemplate.exchange(url + id, HttpMethod.GET, null, HashMap.class);
    return exchange;

  }

  public void deleteBookingDertailsById(Integer id) {
    String url = "http://localhost:5002/booking/delete?id=";
    restTemplate.delete(url + id);
  }

  public Booking postBookingDetails(Booking booking) {
    String url = "http://localhost:5002/booking/post";
    Booking exchange = restTemplate.postForObject(url, booking, Booking.class);
    return exchange;

  }

  public void updateBookingDertailsById(Booking booking) {
    String url = "http://localhost:5002/booking/update";
    restTemplate.put(url, booking, booking.getBookingId());

  }
}	  

