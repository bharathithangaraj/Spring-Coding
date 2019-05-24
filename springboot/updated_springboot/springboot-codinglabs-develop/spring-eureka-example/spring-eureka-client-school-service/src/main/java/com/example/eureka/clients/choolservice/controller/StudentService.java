package com.example.eureka.clients.choolservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("student-service")
public interface StudentService {

  @RequestMapping(value = "/getStudentDetailsForSchool/{school}", method = RequestMethod.GET)
  String getStudents(@PathVariable("school") String school);
}
