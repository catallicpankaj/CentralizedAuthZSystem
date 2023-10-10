package com.pankaj.cas.resources.controller;

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

import com.pankaj.cas.resources.entity.Resources;
import com.pankaj.cas.resources.service.ResourcesService;

@RestController
@RequestMapping("/v1/resources")
public class ResourcesController {

	@Autowired
	private ResourcesService resourceService;

	@PostMapping
	public ResponseEntity<Resources> createResources(@RequestBody Resources resources) {
		Resources createdResource = resourceService.createResources(resources);
		return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Resources>> getAllResources() {
		List<Resources> resource = resourceService.getAllResources();
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Resources> getResourceById(@PathVariable("id") Long resourceId) {
		Resources resource = resourceService.getResourceById(resourceId);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Resources> updateResource(@PathVariable("id") Long resourceId, @RequestBody Resources resources) {
		resources.setResourceId(resourceId);
		Resources updatedResource = resourceService.updateResource(resources);
		return new ResponseEntity<>(updatedResource, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteResource(@PathVariable("id") Long resourceId) {
		resourceService.deleteResource(resourceId);
		return new ResponseEntity<>("principal successfully deleted!", HttpStatus.OK);
	}


}
