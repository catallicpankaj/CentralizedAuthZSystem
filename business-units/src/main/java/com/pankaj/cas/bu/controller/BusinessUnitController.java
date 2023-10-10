package com.pankaj.cas.bu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.cas.bu.entity.Principal;
import com.pankaj.cas.bu.service.BizUnitService;

@RestController
@RequestMapping("/v1/business-unit")
public class BusinessUnitController {

	@Autowired
	private BizUnitService bizUnitService;

	@PostMapping
	public ResponseEntity<Principal> createBizUnit(@RequestBody Principal bizUnit) {
		Principal savedBizUnit = bizUnitService.createBizUnit(bizUnit);
		return new ResponseEntity<>(savedBizUnit, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	// http://localhost:8080/api/users/1
	public ResponseEntity<Principal> getUserById(@PathVariable("id") Long buId) {
		Principal user = bizUnitService.getBizUnitById(buId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Principal>> getAllBizUnits() {
		List<Principal> users = bizUnitService.getAllBusinessUnits();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	// http://localhost:8080/api/users/1
	public ResponseEntity<Principal> updateUser(@PathVariable("id") Long buId, @RequestBody Principal bizUnit) {
		bizUnit.setBuId(buId);
		Principal updatedUser = bizUnitService.updateBizUnit(bizUnit);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long buId) {
		bizUnitService.deleteBizUnit(buId);
		return new ResponseEntity<>("BizUnit successfully deleted!", HttpStatus.OK);
	}

}
