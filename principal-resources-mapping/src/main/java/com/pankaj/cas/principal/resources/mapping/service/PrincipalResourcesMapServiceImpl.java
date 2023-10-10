package com.pankaj.cas.principal.resources.mapping.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.principal.resources.mapping.entity.PrincipalResourcesMap;
import com.pankaj.cas.principal.resources.mapping.repository.PrincipalResourcesMapRepository;

@Service
public class PrincipalResourcesMapServiceImpl implements PrincipalResourcesMapService {

	@Autowired
	PrincipalResourcesMapRepository principalResourcesMapRepository;
	
	@Override
	public PrincipalResourcesMap createPrincipalResourcesMap(PrincipalResourcesMap principalResourcesMap) {
		principalResourcesMap.setCreatedDate(Timestamp.from(Instant.now()));
		principalResourcesMap.setLastModifiedDate(Timestamp.from(Instant.now()));
		return principalResourcesMapRepository.save(principalResourcesMap);
	}

	@Override
	public List<PrincipalResourcesMap> getPrincipalResourcesMapById(String principalResourcesMapId) {
		Optional<List<PrincipalResourcesMap>> optionalPrincipalResourcesMap = principalResourcesMapRepository.findByPrincipalId(principalResourcesMapId);
        return optionalPrincipalResourcesMap.get();
	}

	@Override
	public PrincipalResourcesMap updatePrincipalResourcesMap(PrincipalResourcesMap principalResourcesMap) {
		PrincipalResourcesMap existingPrincipalResourcesMap = principalResourcesMapRepository.findById(principalResourcesMap.getId()).get();
		principalResourcesMap.setCreatedDate(existingPrincipalResourcesMap.getCreatedDate());
		principalResourcesMap.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(principalResourcesMap, existingPrincipalResourcesMap);
		PrincipalResourcesMap updatedPrincipalResources = principalResourcesMapRepository.save(existingPrincipalResourcesMap);
		return updatedPrincipalResources;
	}

	@Override
	public void deletePrincipalResourcesMap(String principalResourcesMapId) {
		principalResourcesMapRepository.deleteById(principalResourcesMapId);
	}

}
