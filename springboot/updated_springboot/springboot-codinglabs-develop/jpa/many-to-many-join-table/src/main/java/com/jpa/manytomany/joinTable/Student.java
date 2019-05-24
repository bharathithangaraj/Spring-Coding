package com.jpa.manytomany.joinTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(name = "course_like",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
  private Set<Course> likedCourses = new HashSet<>();

  // additional properties

  public Student() {
  }

  public Student(String name){
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public Set<Course> getLikedCourses() {
    return likedCourses;
  }

  public Student setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public Student setLikedCourses(Set<Course> likedCourses) {
    this.likedCourses = likedCourses;
    return this;
  }

  public Student addCourse(Course course){
    getLikedCourses().add(course);
    return  this;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}