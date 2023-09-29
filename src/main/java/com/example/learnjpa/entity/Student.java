package com.example.learnjpa.entity;

import com.example.learnjpa.entity.base.Auditor;
import com.example.learnjpa.entity.enums.Sex;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "sex")
  @Enumerated(EnumType.STRING)
  private Sex sex;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(
      name = "address_id",
      referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "FK_STUDENT_ADDRESS"))
  private Address address;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
  private List<Course> courses;

  @Embedded private Auditor auditor;
}
