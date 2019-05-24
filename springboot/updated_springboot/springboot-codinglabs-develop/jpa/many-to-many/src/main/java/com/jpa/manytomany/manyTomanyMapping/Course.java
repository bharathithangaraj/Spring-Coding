package com.jpa.manytomany.manyTomanyMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany
  private Set<Student> likes = new HashSet<>();


  // additional properties

  public Course() {
  }

  public Course(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public Course setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Course setName(String name) {
    this.name = name;
    return this;
  }

  public Set<Student> getLikes() {
    return likes;
  }

  public Course setLikes(Set<Student> likes) {
    this.likes = likes;
    return this;
  }

  public Course addStudent(Student student) {
    getLikes().add(student);
    student.getLikedCourses().add(this);
    return this;
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
    Course other = (Course) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}