package com.jpa.manytomany.joinTable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTests {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  StudentRepo studentRepo;

  @Autowired
  CourseRepo courseRepo;

  @Test
  public void testManyToMany() {
    Course course = new Course("Spring Boot");
    Student student = new Student("S1");

    courseRepo.save(course);

    studentRepo.save(student);

    logger.info("Before adding course");

    student.addCourse(course);

    logger.info("After adding course");
    studentRepo.save(student);
    logger.info("After  saving student");

  }

}
