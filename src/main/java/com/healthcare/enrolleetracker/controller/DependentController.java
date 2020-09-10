package com.healthcare.enrolleetracker.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.enrolleetracker.bean.Dependent;
import com.healthcare.enrolleetracker.bean.Enrollee;
import com.healthcare.enrolleetracker.dao.DependentRepository;
import com.healthcare.enrolleetracker.vo.DependentVO;

@RestController
@RequestMapping("/dependent")
public class DependentController {

	@Autowired
	DependentRepository dependentRepository;

	@GetMapping("/getAll")
	public List<Dependent> getdependents() {

		return dependentRepository.findAll();
	}
	
	@GetMapping("/get/{dependentId}")
	public Dependent getdependent(@PathVariable Long dependentId) {	
		Dependent e = new Dependent();
		Optional<Dependent> opt = dependentRepository.findById(dependentId);

		if (opt.isPresent()) {
			 e = opt.get();
		}
		return e;
	}

	@PostMapping("/savedependent")
	public void savedependent(@RequestBody DependentVO dependent) {

		Dependent d = new Dependent();
		d.setName(dependent.getName());
		d.setDob(Date.valueOf(dependent.getDob()));
		Enrollee e =new Enrollee();
		e.setId(dependent.getEnrolleeId());
		d.setEnrollee(e);

		dependentRepository.save(d);
	}

	@PutMapping("/updatedependent")
	public void updatedependent(@RequestBody DependentVO dependent) {

		Optional<Dependent> opt = dependentRepository.findById(dependent.getId());

		if (opt.isPresent()) {
			Dependent e = opt.get();
			e.setName(dependent.getName());
			e.setDob(Date.valueOf(dependent.getDob()));

			dependentRepository.save(e);
		}

	}
	/*
	@DeleteMapping("/delete/{dependentId}")
	public void deletedependent(@PathVariable Long dependentId) {
	
		dependentRepository.deleteById(dependentId);
	}
	*/
}

