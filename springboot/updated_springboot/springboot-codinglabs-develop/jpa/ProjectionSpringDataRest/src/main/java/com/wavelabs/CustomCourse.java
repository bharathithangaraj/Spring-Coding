package com.wavelabs;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customCourse", types = Course.class)
public interface CustomCourse {
	String getCourseName();
	//String getDuration();
}
