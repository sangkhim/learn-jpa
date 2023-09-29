package com.example.learnjpa.repository;

import com.example.learnjpa.entity.Address;
import com.example.learnjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}
