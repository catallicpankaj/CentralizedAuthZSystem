package com.pankaj.cas.permission.controller;

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

import com.pankaj.cas.permission.entity.Permissions;
import com.pankaj.cas.permission.service.PermissionsService;

@RestController
@RequestMapping("/v1/permissions")
public class PermissionsController {

	@Autowired
	private PermissionsService permissionsService;

	@PostMapping
	public ResponseEntity<Permissions> createPermissions(@RequestBody Permissions permissions) {
		Permissions createdPermission = permissionsService.createPermissions(permissions);
		return new ResponseEntity<>(createdPermission, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Permissions>> getAllResources() {
		List<Permissions> resource = permissionsService.getAllPermissions();
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Permissions> getPermissionById(@PathVariable("id") String permissionId) {
		Permissions permissions = permissionsService.getPermissionById(permissionId);
		return new ResponseEntity<>(permissions, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Permissions> updatePermission(@PathVariable("id") String permissionId, @RequestBody Permissions permissions) {
		permissions.setPermissionId(permissionId);
		Permissions updatedPermission = permissionsService.updatePermission(permissions);
		return new ResponseEntity<>(updatedPermission, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String permissionId) {
		permissionsService.deletePermission(permissionId);
		return new ResponseEntity<>("principal successfully deleted!", HttpStatus.OK);
	}


}
