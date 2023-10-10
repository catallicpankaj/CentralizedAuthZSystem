package com.pankaj.cas.resources.service;

import java.util.List;

import com.pankaj.cas.resources.entity.Resources;

public interface ResourcesService {

	Resources createResources(Resources resources);
	
	List<Resources> getAllResources();

	Resources getResourceById(Long buId);

    Resources updateResource(Resources resources);

    void deleteResource(Long buId);

}
