package com.pankaj.cas.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pankaj.cas.principal.entity.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {

	@Query("select p from Principal p where p.principalId = ?1")
	Optional<Principal> findByPrincipalId(String principalId);

}
