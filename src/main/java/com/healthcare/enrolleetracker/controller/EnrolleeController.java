package com.healthcare.enrolleetracker.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.healthcare.enrolleetracker.dao.EnrolleeRepository;
import com.healthcare.enrolleetracker.vo.EnrolleeVO;

@RestController
@RequestMapping("/enrollee")
public class EnrolleeController {
	@Autowired
	EnrolleeRepository enrolleeRepository;

	@Autowired
	DependentRepository dependentRepository;

	@GetMapping("/getAll")
	public List<Enrollee> getEnrollees() {

		return enrolleeRepository.findAll();
	}
	
	@GetMapping("/get/{enrolleId}")
	public Enrollee getEnrollee(@PathVariable Long enrolleId) {	
		Enrollee e = new Enrollee();
		Optional<Enrollee> opt = enrolleeRepository.findById(enrolleId);

		if (opt.isPresent()) {
			 e = opt.get();
		}
		return e;
	}

	@PostMapping("/saveEnrollee")
	public void saveEnrollee(@RequestBody EnrolleeVO enrollee) {

		Enrollee e = new Enrollee();
		e.setName(enrollee.getName());
		e.setStatus(enrollee.getStatus().equals(true) ? "T" : "F");
		e.setPhoneNumber(enrollee.getPhoneNumber());
		e.setDob(Date.valueOf(enrollee.getDob()));

		enrolleeRepository.save(e);
	}

	@PutMapping("/updateEnrollee")
	public void updateEnrollee(@RequestBody EnrolleeVO enrollee) {

		Optional<Enrollee> opt = enrolleeRepository.findById(enrollee.getId());

		if (opt.isPresent()) {
			Enrollee e = opt.get();
			e.setName(enrollee.getName());
			e.setStatus(enrollee.getStatus().equals(true) ? "T" : "F");
			e.setPhoneNumber(enrollee.getPhoneNumber());
			e.setDob(Date.valueOf(enrollee.getDob()));

			enrolleeRepository.save(e);
		}

	}
	
	@DeleteMapping("/delete/{enrolleId}")
	public void deleteEnrollee(@PathVariable Long enrolleId) {
	
		Enrollee e = new Enrollee();
		e.setId(enrolleId);
		enrolleeRepository.delete(e);
	}
	

	
	@DeleteMapping("/delete/{enrolleId}/{dependentId}")
	public void deleteDependentEnrollee(@PathVariable Long enrolleId, @PathVariable Long dependentId) {
	
		Enrollee e =enrolleeRepository.findById(enrolleId).get();
		
		Dependent d = dependentRepository.findById(dependentId).get();
		
		e.getDependentList().remove(d);
		enrolleeRepository.save(e);
		dependentRepository.delete(d);
	}

	
	@DeleteMapping("/delete/{enrolleId}/all")
	public void deleteAllDependentEnrollee(@PathVariable Long enrolleId) {
	
		Enrollee e =enrolleeRepository.findById(enrolleId).get();
		List<Dependent> dependentList = e.getDependentList();
		e.getDependentList().clear();
		enrolleeRepository.save(e);
		dependentRepository.deleteAll(dependentList);
	}
	
	

}
