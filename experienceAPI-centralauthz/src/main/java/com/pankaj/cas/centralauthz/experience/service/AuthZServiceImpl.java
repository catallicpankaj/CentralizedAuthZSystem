package com.pankaj.cas.centralauthz.experience.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pankaj.cas.centralauthz.experience.service.model.Permissions;
import com.pankaj.cas.centralauthz.experience.service.model.PrincipalResourceDTO;
import com.pankaj.cas.centralauthz.experience.service.model.PrincipalResourceMapping;
import com.pankaj.cas.centralauthz.experience.service.model.Resources;
import com.pankaj.cas.centralauthz.experience.service.model.ResourcesDTO;

@Service
public class AuthZServiceImpl implements AuthZService {

	@Autowired
	private WebClient webClient;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private final static String principalResourceMapUri = "http://localhost:8084/digital-auth/central-authz/v1/principal-resource-mapping/";
	private final static String resourceUri = "http://localhost:8085/digital-auth/central-authz/v1/resources";
	private final static String permissionUri = "http://localhost:8085/digital-auth/central-authz/v1/permissions";
	Map<Long, String> resourceIdToResourceMap = new HashMap<>(); 
	Map<Long, String> permissionIdMap = new HashMap<>(); 
	
	@Override
	public PrincipalResourceDTO getPrincipalResourceMapByPrincipalId(Long buId, String principalId) throws JsonMappingException, JsonProcessingException {
		retrieveCacheObjects();
		String prMapData = webClient.get().uri(principalResourceMapUri + principalId).retrieve().bodyToMono(String.class).block();
		List<PrincipalResourceMapping> listOfPrMapData = objectMapper.readValue(prMapData,
				objectMapper.getTypeFactory().constructCollectionType(List.class, PrincipalResourceMapping.class));
		PrincipalResourceDTO principalResourceDTO = new PrincipalResourceDTO();
		principalResourceDTO.setOrgId(String.valueOf(buId));
		principalResourceDTO.setPrincipalId(principalId);
		principalResourceDTO.setRoles(new ArrayList<>());
		listOfPrMapData.forEach(data->{
			ResourcesDTO resourcesDTO = new ResourcesDTO();
			resourcesDTO.setResource(resourceIdToResourceMap.get(Long.parseLong(data.getResourcesId())));
			resourcesDTO.setPermissions(null);
		});
		return null;
	}

	private void retrieveCacheObjects() throws JsonProcessingException, JsonMappingException {
		if (resourceIdToResourceMap.isEmpty()) {
			String resources = webClient.get().uri(resourceUri).retrieve().bodyToMono(String.class).block();
			List<Resources> listOfResources = objectMapper.readValue(resources,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Resources.class));
			listOfResources.forEach(resource -> {
				resourceIdToResourceMap.put(resource.getResourceId(), resource.getResource());
			});
		}
		if (permissionIdMap.isEmpty()) {
			String permissions = webClient.get().uri(permissionUri).retrieve().bodyToMono(String.class).block();
			List<Permissions> listOfPermissions = objectMapper.readValue(permissions,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Permissions.class));
			listOfPermissions.forEach(resource -> {
				resourceIdToResourceMap.put(resource.getResourceId(), resource.getResource());
			});
		}
	}

	@Override
	public PrincipalResourceDTO getPrincipalResourceMapByResourceId(Long buId, String principalId, Long resourceId) {

		return null;
	}

}
