package com.pankaj.cas.roles.controller;

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

import com.pankaj.cas.roles.entity.Roles;
import com.pankaj.cas.roles.service.RolesService;

@RestController
@RequestMapping("/v1/roles")
public class RolesController {



	@Autowired
	private RolesService roleService;

	@PostMapping
	public ResponseEntity<Roles> createprincipal(@RequestBody Roles roles) {
		Roles createdRole = roleService.createRoles(roles);
		return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Roles> getUserById(@PathVariable("id") Long roleId) {
		Roles role = roleService.getRoleById(roleId);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Roles> updateUser(@PathVariable("id") Long roleId, @RequestBody Roles roles) {
		roles.setRoleId(roleId);
		Roles updatedRole = roleService.updateRole(roles);
		return new ResponseEntity<>(updatedRole, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long roleId) {
		roleService.deleteRole(roleId);
		return new ResponseEntity<>("principal successfully deleted!", HttpStatus.OK);
	}


}
