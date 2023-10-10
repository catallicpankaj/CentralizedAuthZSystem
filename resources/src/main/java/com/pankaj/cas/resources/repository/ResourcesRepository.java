package com.pankaj.cas.resources.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.cas.resources.entity.Resources;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {

}
