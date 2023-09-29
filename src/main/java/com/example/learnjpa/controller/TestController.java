package com.example.learnjpa.controller;

import com.example.learnjpa.entity.Address;
import com.example.learnjpa.entity.Course;
import com.example.learnjpa.entity.Student;
import com.example.learnjpa.entity.base.Auditor;
import com.example.learnjpa.entity.enums.Sex;
import com.example.learnjpa.repository.StudentRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TestController {

  private final StudentRepository studentRepository;

  @GetMapping("/get")
  public ResponseEntity<List<Student>> get() {
    List<Student> students = studentRepository.findAll();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<Void> save() {
    Student student = new Student();
    student.setName("admin");
    student.setSex(Sex.FEMALE);

    Auditor auditor = new Auditor();
    auditor.setCreatedDate(new Date());
    auditor.setCreatedBy("operator");
    student.setAuditor(auditor);

    Address address = new Address();
    address.setAddress("#95, st. 608");
    student.setAddress(address);

    Course course1 = new Course();
    course1.setName("Physic");
    Course course2 = new Course();
    course2.setName("Math");

    student.setCourses(Arrays.asList(course1, course2));

    studentRepository.save(student);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/update/{studentId}")
  public ResponseEntity<Void> update(@PathVariable("studentId") Long studentId) {
    Student student = studentRepository.findById(studentId).get();
    student.setName("admin update");
    student.setSex(Sex.MALE);

    Auditor auditor = new Auditor();
    auditor.setCreatedDate(new Date());
    auditor.setCreatedBy("operator");
    student.setAuditor(auditor);

    Address address = student.getAddress();
    address.setAddress("#95, st. 608 update");
    student.setAddress(address);

    student.getCourses().forEach(course -> {
      course.setName(course.getName() + " update");
    });

    studentRepository.save(student);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
