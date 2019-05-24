package com.jpa.manytomany.manyTomanyMapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTests {

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

    student.addCourse(course);

    studentRepo.save(student);

    courseRepo.save(course);

  }

}
