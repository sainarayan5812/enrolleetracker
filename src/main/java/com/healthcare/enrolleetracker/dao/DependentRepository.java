package com.healthcare.enrolleetracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.enrolleetracker.bean.Dependent;

public interface DependentRepository extends JpaRepository<Dependent, Long> {

}
