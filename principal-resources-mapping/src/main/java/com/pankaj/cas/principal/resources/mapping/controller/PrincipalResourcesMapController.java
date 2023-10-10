package com.pankaj.cas.principal.resources.mapping.controller;

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

import com.pankaj.cas.principal.resources.mapping.entity.PrincipalResourcesMap;
import com.pankaj.cas.principal.resources.mapping.service.PrincipalResourcesMapService;

@RestController
@RequestMapping("/v1/principal-resource-mapping")
public class PrincipalResourcesMapController {

	@Autowired
	private PrincipalResourcesMapService principalResourcesMapService;

	@PostMapping
	public ResponseEntity<PrincipalResourcesMap> createPrincipalResourcesMap(@RequestBody PrincipalResourcesMap principalResourcesMap) {
		PrincipalResourcesMap createdPrincipalResourcesMap = principalResourcesMapService.createPrincipalResourcesMap(principalResourcesMap);
		return new ResponseEntity<>(createdPrincipalResourcesMap, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<List<PrincipalResourcesMap>> getPrincipalResourcesMapById(@PathVariable("id") String id) {
		List<PrincipalResourcesMap> PrincipalResourcesMap = principalResourcesMapService.getPrincipalResourcesMapById(id);
		return new ResponseEntity<>(PrincipalResourcesMap, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<PrincipalResourcesMap> updatePrincipalResourcesMap(@PathVariable("id") String id, @RequestBody PrincipalResourcesMap PrincipalResourcesMap) {
		PrincipalResourcesMap.setId(id);
		PrincipalResourcesMap updatedPrincipalResourcesMap = principalResourcesMapService.updatePrincipalResourcesMap(PrincipalResourcesMap);
		return new ResponseEntity<>(updatedPrincipalResourcesMap, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		principalResourcesMapService.deletePrincipalResourcesMap(id);
		return new ResponseEntity<>("principal successfully deleted!", HttpStatus.OK);
	}


}
