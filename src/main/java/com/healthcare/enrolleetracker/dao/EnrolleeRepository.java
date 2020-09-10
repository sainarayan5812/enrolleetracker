package com.healthcare.enrolleetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.enrolleetracker.bean.Enrollee;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Long> {

}
