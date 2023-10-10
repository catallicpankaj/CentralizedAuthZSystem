package com.pankaj.cas.permission.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.permission.entity.Permissions;
import com.pankaj.cas.permission.repository.PermissionsRepository;

@Service
public class PermissionsServiceImpl implements PermissionsService {

	@Autowired
	PermissionsRepository permissionRepository;
	
	@Override
	public Permissions createPermissions(Permissions permissions) {
		permissions.setCreatedDate(Timestamp.from(Instant.now()));
		permissions.setLastModifiedDate(Timestamp.from(Instant.now()));
		return permissionRepository.save(permissions);
	}

	@Override
	public Permissions getPermissionById(String permissionId) {
		Optional<Permissions> optionalprincipal = permissionRepository.findById(permissionId);
        return optionalprincipal.get();
	}

	@Override
	public Permissions updatePermission(Permissions permissions) {
		Permissions existingPermissions = permissionRepository.findById(permissions.getPermissionId()).get();
		permissions.setCreatedDate(existingPermissions.getCreatedDate());
		permissions.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(permissions, existingPermissions);
		Permissions updatedprincipal = permissionRepository.save(existingPermissions);
		return updatedprincipal;
	}

	@Override
	public void deletePermission(String permissionId) {
		permissionRepository.deleteById(permissionId);
		
	}

}
