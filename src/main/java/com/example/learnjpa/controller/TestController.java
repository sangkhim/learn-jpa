package com.example.learnjpa.controller;

import com.example.learnjpa.entity.Address;
import com.example.learnjpa.entity.Order;
import com.example.learnjpa.entity.Student;
import com.example.learnjpa.entity.User;
import com.example.learnjpa.entity.base.Auditor;
import com.example.learnjpa.repository.StudentRepository;
import com.example.learnjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TestController {

  private final UserRepository userRepository;
  private final StudentRepository studentRepository;

  @GetMapping("/test")
  public ResponseEntity<Void> test() {
    Student student = new Student();
    Auditor auditor = new Auditor();
    auditor.setCreatedBy("sangkhim");
    student.setAuditor(auditor);
    studentRepository.save(student);

    User user = new User();
    user.setName("sangkhim");

    Address address = new Address();
    address.setId(1L);
    user.setAddress(address);

    List<Order> orders = new ArrayList<>();
    Order order = new Order();
    order.setId(1L);
    order.setUser(user);
    orders.set(1, order);
    user.setOrders(orders);

    userRepository.save(user);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
