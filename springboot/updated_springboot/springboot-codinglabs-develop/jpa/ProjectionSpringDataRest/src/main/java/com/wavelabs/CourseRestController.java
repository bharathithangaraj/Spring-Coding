package com.wavelabs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome Device Data Access Application with Restful Services";
    }
	
	@GetMapping(value="course/get/{id}", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
    public Optional<Course> getDevice(@PathVariable("id") Long id) {
		return courseRepository.findById(id);
    }
	
}
