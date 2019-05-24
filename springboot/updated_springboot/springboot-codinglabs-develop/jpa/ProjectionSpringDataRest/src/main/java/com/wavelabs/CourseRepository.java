package com.wavelabs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path = "course", excerptProjection = CustomCourse.class)
public interface CourseRepository extends CrudRepository<Course, Long> {
	
}
