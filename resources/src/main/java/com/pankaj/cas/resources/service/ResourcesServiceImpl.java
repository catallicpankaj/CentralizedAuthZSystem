package com.pankaj.cas.resources.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.resources.entity.Resources;
import com.pankaj.cas.resources.repository.ResourcesRepository;

@Service
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	ResourcesRepository resourcesRepository;
	
	@Override
	public Resources createResources(Resources Resources) {
		Resources.setCreatedDate(Timestamp.from(Instant.now()));
		Resources.setLastModifiedDate(Timestamp.from(Instant.now()));
		return resourcesRepository.save(Resources);
	}
	
	@Override
	public List<Resources> getAllResources() {
		return resourcesRepository.findAll();
	}


	@Override
	public Resources getResourceById(Long resourceId) {
		Optional<Resources> optionalResource = resourcesRepository.findById(resourceId);
        return optionalResource.get();
	}

	@Override
	public Resources updateResource(Resources Resources) {
		Resources existingResources = resourcesRepository.findById(Resources.getResourceId()).get();
		Resources.setCreatedDate(existingResources.getCreatedDate());
		Resources.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(Resources, existingResources);
		Resources updatedResource = resourcesRepository.save(existingResources);
		return updatedResource;
	}

	@Override
	public void deleteResource(Long resourceId) {
		resourcesRepository.deleteById(resourceId);
		
	}

	
}
