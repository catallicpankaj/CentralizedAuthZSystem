package com.pankaj.cas.principal.controller;

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

import com.pankaj.cas.principal.entity.Principal;
import com.pankaj.cas.principal.service.PrincipalService;

@RestController
@RequestMapping("/v1/principal")
public class PrincipalController {

	@Autowired
	private PrincipalService principalService;

	@PostMapping
	public ResponseEntity<Principal> createprincipal(@RequestBody Principal principal) {
		Principal savedprincipal = principalService.createPrincipal(principal);
		return new ResponseEntity<>(savedprincipal, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Principal> getUserById(@PathVariable("id") String principalId) {
		Principal user = principalService.getPrincipalById(principalId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Principal>> getAllprincipals() {
		List<Principal> users = principalService.getAllPrincipals();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Principal> updateUser(@PathVariable("id") Long principalId, @RequestBody Principal principal) {
		principal.setPrincipalId(principalId);
		Principal updatedUser = principalService.updatePrincipal(principal);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long principalId) {
		principalService.deletePrincipal(principalId);
		return new ResponseEntity<>("principal successfully deleted!", HttpStatus.OK);
	}

}
