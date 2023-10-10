package com.pankaj.cas.centralauthz.experience.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pankaj.cas.centralauthz.experience.service.model.PrincipalResourceDTO;

public interface AuthZService {

	public PrincipalResourceDTO getPrincipalResourceMapByPrincipalId(Long buId, String principalId)
			throws JsonMappingException, JsonProcessingException;

	public PrincipalResourceDTO getPrincipalResourceMapByResourceId(Long buId, String principalId, Long resourceId)
			throws JsonMappingException, JsonProcessingException;
}
