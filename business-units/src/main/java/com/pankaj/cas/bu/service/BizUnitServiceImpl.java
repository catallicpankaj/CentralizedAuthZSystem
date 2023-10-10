package com.pankaj.cas.bu.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.cas.bu.entity.Principal;
import com.pankaj.cas.bu.repository.BizUnitRepository;

@Service
public class BizUnitServiceImpl implements BizUnitService{

	@Autowired
	BizUnitRepository bizUnitRepository;
	
	@Override
	public Principal createBizUnit(Principal bizUnit) {
		bizUnit.setCreatedDate(Timestamp.from(Instant.now()));
		bizUnit.setLastModifiedDate(Timestamp.from(Instant.now()));
		return bizUnitRepository.save(bizUnit);
	}

	@Override
	public Principal getBizUnitById(Long buId) {
		Optional<Principal> optionalBizUnit = bizUnitRepository.findById(buId);
        return optionalBizUnit.get();
	}

	@Override
	public List<Principal> getAllBusinessUnits() {
		return bizUnitRepository.findAll();
	}

	@Override
	public Principal updateBizUnit(Principal bizUnit) {
		Principal existingUser = bizUnitRepository.findById(bizUnit.getBuId()).get();
		bizUnit.setCreatedDate(existingUser.getCreatedDate());
		bizUnit.setLastModifiedDate(Timestamp.from(Instant.now()));
		BeanUtils.copyProperties(bizUnit, existingUser);
		Principal updatedBizUnit = bizUnitRepository.save(existingUser);
		return updatedBizUnit;
	}

	@Override
	public void deleteBizUnit(Long buId) {
		bizUnitRepository.deleteById(buId);
	}

}
