package com.pankaj.cas.roles.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.roles.entity.Roles;
import com.pankaj.cas.roles.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	RolesRepository rolesRepository;
	
	@Override
	public Roles createRoles(Roles roles) {
		roles.setCreatedDate(Timestamp.from(Instant.now()));
		roles.setLastModifiedDate(Timestamp.from(Instant.now()));
		return rolesRepository.save(roles);
	}

	@Override
	public Roles getRoleById(Long roleId) {
		Optional<Roles> optionalRole = rolesRepository.findById(roleId);
        return optionalRole.get();
	}

	@Override
	public Roles updateRole(Roles roles) {
		Roles existingRoles = rolesRepository.findById(roles.getRoleId()).get();
		roles.setCreatedDate(existingRoles.getCreatedDate());
		roles.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(roles, existingRoles);
		Roles updatedRole = rolesRepository.save(existingRoles);
		return updatedRole;
	}

	@Override
	public void deleteRole(Long roleId) {
		rolesRepository.deleteById(roleId);
		
	}

}
