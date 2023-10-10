package com.pankaj.cas.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.cas.roles.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

}
