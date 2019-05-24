package com.jpa.manytomany.manyTomanyMapping;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
