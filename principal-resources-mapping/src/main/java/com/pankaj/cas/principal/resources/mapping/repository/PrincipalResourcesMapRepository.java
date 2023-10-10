package com.pankaj.cas.principal.resources.mapping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pankaj.cas.principal.resources.mapping.entity.PrincipalResourcesMap;

public interface PrincipalResourcesMapRepository extends JpaRepository<PrincipalResourcesMap, Long> {

	@Query("select p from PrincipalResourcesMap p where p.principalId= ?1")
	Optional<List<PrincipalResourcesMap>> findByPrincipalId(String id);
	
	@Query("select p from PrincipalResourcesMap p where p.id= ?1")
	Optional<PrincipalResourcesMap> findById(String id);

	@Query("delete from PrincipalResourcesMap p where p.principalId= ?1")
	void deleteById(String id);
}
