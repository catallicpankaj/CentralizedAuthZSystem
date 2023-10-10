package com.pankaj.cas.centralauthz.experience.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pankaj.cas.centralauthz.experience.service.AuthZService;
import com.pankaj.cas.centralauthz.experience.service.model.PrincipalResourceDTO;
import com.pankaj.cas.centralauthz.experience.service.model.PrincipalResourceMapping;

@RestController
@RequestMapping("/v1/authz")
public class AuthZController {

	@Autowired
	AuthZService authZService;

	@GetMapping("/business-unit/{buId}/principal/{principalId}")
	public ResponseEntity<PrincipalResourceDTO> getPrincipalResourceMapByPrincipalId(@PathVariable("buId") Long buId,
			@PathVariable("principalId") String principalId) throws JsonMappingException, JsonProcessingException {
		PrincipalResourceDTO prMapData = authZService.getPrincipalResourceMapByPrincipalId(buId, principalId);
		return new ResponseEntity<>(prMapData, HttpStatus.OK);
	}

	@GetMapping("/business-unit/{buId}/principal/{principalId}/resource/{resourceId}")
	public ResponseEntity<PrincipalResourceDTO> getPrincipalResourceMapByResourceId(@PathVariable("buId") Long buId,
			@PathVariable("principalId") String principalId, @PathVariable("resourceId") Long resourceId)
			throws JsonMappingException, JsonProcessingException {
		PrincipalResourceDTO prMapData = authZService.getPrincipalResourceMapByResourceId(buId, principalId,
				resourceId);
		return new ResponseEntity<>(prMapData, HttpStatus.OK);
	}
}
