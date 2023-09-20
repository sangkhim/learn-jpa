package com.example.learnjpa.controller;

import com.example.learnjpa.entity.Address;
import com.example.learnjpa.entity.Order;
import com.example.learnjpa.entity.Student;
import com.example.learnjpa.entity.User;
import com.example.learnjpa.entity.base.Auditor;
import com.example.learnjpa.repository.OrderRepository;
import com.example.learnjpa.repository.StudentRepository;
import com.example.learnjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TestController {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;
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
    userRepository.save(user);

    Order order = new Order();
    order.setUser(user);
    order.setTotal(100.0);
    orderRepository.save(order);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
