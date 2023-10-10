package com.pankaj.cas.bu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pankaj.cas.bu.entity.Principal;

public interface BizUnitRepository extends JpaRepository<Principal, Long> {

}
