package com.pankaj.cas.permission.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pankaj.cas.permission.entity.Permissions;

public interface PermissionsRepository extends JpaRepository<Permissions, Long> {

	@Query("select p from Permissions p where p.permissionId= ?1")
	Optional<Permissions> findById(String id);

	@Query("delete from Permissions p where p.permissionId= ?1")
	void deleteById(String id);
}
