package com.pankaj.cas.principal.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.principal.entity.Principal;
import com.pankaj.cas.principal.repository.PrincipalRepository;

@Service
public class PrincipalServiceImpl implements PrincipalService{

	@Autowired
	PrincipalRepository principalRepository;
	
	@Override
	public Principal createPrincipal(Principal principal) {
		principal.setCreatedDate(Timestamp.from(Instant.now()));
		principal.setLastModifiedDate(Timestamp.from(Instant.now()));
		return principalRepository.save(principal);
	}

	@Override
	public Principal getPrincipalById(String principalId) {
		Optional<Principal> optionalprincipal = principalRepository.findByPrincipalId(principalId);
        return optionalprincipal.get();
	}

	@Override
	public List<Principal> getAllPrincipals() {
		return principalRepository.findAll();
	}

	@Override
	public Principal updatePrincipal(Principal principal) {
		Principal existingPrincipal = principalRepository.findById(principal.getPrincipalId()).get();
		principal.setCreatedDate(existingPrincipal.getCreatedDate());
		principal.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(principal, existingPrincipal);
		Principal updatedprincipal = principalRepository.save(existingPrincipal);
		return updatedprincipal;
	}

	@Override
	public void deletePrincipal(Long buId) {
		principalRepository.deleteById(buId);
	}

}
