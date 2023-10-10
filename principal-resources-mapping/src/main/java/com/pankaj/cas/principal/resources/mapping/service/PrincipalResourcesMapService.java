package com.pankaj.cas.principal.resources.mapping.service;

import java.util.List;

import com.pankaj.cas.principal.resources.mapping.entity.PrincipalResourcesMap;

public interface PrincipalResourcesMapService {

	PrincipalResourcesMap createPrincipalResourcesMap(PrincipalResourcesMap principalResourcesMaps);

	List<PrincipalResourcesMap> getPrincipalResourcesMapById(String principalResourcesMapId);

	PrincipalResourcesMap updatePrincipalResourcesMap(PrincipalResourcesMap principalResourcesMaps);

    void deletePrincipalResourcesMap(String principalResourcesMapId);

}
