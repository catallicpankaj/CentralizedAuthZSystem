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

import jakarta.annotation.PostConstruct;

@Service
public class AuthZServiceImpl implements AuthZService {

	@Autowired
	private WebClient webClient;

	@Autowired
	ObjectMapper objectMapper;

	private final static String PRINCIPAL_RESOURCE_MAP_URI = "http://localhost:8084/digital-auth/central-authz/v1/principal-resource-mapping/";
	private final static String RESOURCE_URI = "http://localhost:8085/digital-auth/central-authz/v1/resources";
	private final static String PERMISSION_URI = "http://localhost:8083/digital-auth/central-authz/v1/permissions";

	Map<Long, String> resourceIdToResourceMap = new HashMap<>();
	Map<Long, List<String>> permissionIdMap = new HashMap<>();

	@PostConstruct
	public void init() throws JsonMappingException, JsonProcessingException {
		retrieveCacheObjects();
	}

	@Override
	public PrincipalResourceDTO getPrincipalResourceMapByPrincipalId(Long buId, String principalId)
			throws JsonMappingException, JsonProcessingException {
		String prMapData = webClient.get().uri(PRINCIPAL_RESOURCE_MAP_URI + principalId).retrieve()
				.bodyToMono(String.class).block();
		List<PrincipalResourceMapping> listOfPrMapData = objectMapper.readValue(prMapData,
				objectMapper.getTypeFactory().constructCollectionType(List.class, PrincipalResourceMapping.class));
		PrincipalResourceDTO principalResourceDTO = getPrincipalResourcesDTO(buId, principalId, null, listOfPrMapData);
		return principalResourceDTO;
	}
	
	@Override
	public PrincipalResourceDTO getPrincipalResourceMapByResourceId(Long buId, String principalId, Long resourceId)
			throws JsonMappingException, JsonProcessingException {
		String prMapData = webClient.get().uri(PRINCIPAL_RESOURCE_MAP_URI + principalId).retrieve()
				.bodyToMono(String.class).block();
		List<PrincipalResourceMapping> listOfPrMapData = objectMapper.readValue(prMapData,
				objectMapper.getTypeFactory().constructCollectionType(List.class, PrincipalResourceMapping.class));
		PrincipalResourceDTO principalResourceDTO = getPrincipalResourcesDTO(buId, principalId, resourceId, listOfPrMapData);
		return principalResourceDTO;
	}

	private PrincipalResourceDTO getPrincipalResourcesDTO(Long buId, String principalId, Long resourceId,
			List<PrincipalResourceMapping> listOfPrMapData) {
		PrincipalResourceDTO principalResourceDTO = new PrincipalResourceDTO();
		principalResourceDTO.setOrgId(String.valueOf(buId));
		principalResourceDTO.setPrincipalId(principalId);
		principalResourceDTO.setRoles(new ArrayList<>());
		List<ResourcesDTO> resourcesDTOList = new ArrayList<>();
		listOfPrMapData.forEach(data -> {
			if (resourceId == null) {
				ResourcesDTO resourcesDTO = new ResourcesDTO();
				resourcesDTO.setId(Long.parseLong(data.getResourcesId()));
				resourcesDTO.setResource(resourceIdToResourceMap.get(Long.parseLong(data.getResourcesId())));
				resourcesDTO.setPermissions(permissionIdMap.get(Long.parseLong(data.getPermissionId())));
				resourcesDTOList.add(resourcesDTO);
			} else {
				if (data.getResourcesId() != null && data.getResourcesId().equals(String.valueOf(resourceId))) {
					ResourcesDTO resourcesDTO = new ResourcesDTO();
					resourcesDTO.setId(Long.parseLong(data.getResourcesId()));
					resourcesDTO.setResource(resourceIdToResourceMap.get(Long.parseLong(data.getResourcesId())));
					resourcesDTO.setPermissions(permissionIdMap.get(Long.parseLong(data.getPermissionId())));
					resourcesDTOList.add(resourcesDTO);
				}
			}
		});
		principalResourceDTO.setResources(resourcesDTOList);
		return principalResourceDTO;
	}

	private void retrieveCacheObjects() throws JsonProcessingException, JsonMappingException {
		if (resourceIdToResourceMap.isEmpty()) {
			String resources = webClient.get().uri(RESOURCE_URI).retrieve().bodyToMono(String.class).block();
			List<Resources> listOfResources = objectMapper.readValue(resources,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Resources.class));
			listOfResources.forEach(resource -> {
				resourceIdToResourceMap.put(resource.getResourceId(), resource.getResource());
			});
		}
		if (permissionIdMap.isEmpty()) {
			String permissions = webClient.get().uri(PERMISSION_URI).retrieve().bodyToMono(String.class).block();
			List<Permissions> listOfPermissions = objectMapper.readValue(permissions,
					objectMapper.getTypeFactory().constructCollectionType(List.class, Permissions.class));
			listOfPermissions.forEach(perm -> {
				permissionIdMap.put(Long.valueOf(perm.getPermissionId()), getListOfPermissionsForPermissionId(perm));
			});
		}
	}

	private List<String> getListOfPermissionsForPermissionId(Permissions perm) {
		List<String> permissionsString = new ArrayList<>();
		if (perm.isCanCreate()) {
			permissionsString.add("canCreate");
		}
		if (perm.isCanRead()) {
			permissionsString.add("canRead");
		}
		if (perm.isCanUpdate()) {
			permissionsString.add("canUpdate");
		}
		if (perm.isCanDelete()) {
			permissionsString.add("canDelete");
		}
		return permissionsString;
	}

}
