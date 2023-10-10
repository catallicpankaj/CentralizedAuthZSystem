package com.pankaj.cas.bu.service;

import java.util.List;

import com.pankaj.cas.bu.entity.Principal;

public interface BizUnitService {

	Principal createBizUnit(Principal bizUnit);

	Principal getBizUnitById(Long buId);

    List<Principal> getAllBusinessUnits();

    Principal updateBizUnit(Principal user);

    void deleteBizUnit(Long buId);

}
