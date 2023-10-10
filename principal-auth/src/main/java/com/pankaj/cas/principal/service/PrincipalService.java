package com.pankaj.cas.principal.service;

import java.util.List;

import com.pankaj.cas.principal.entity.Principal;

public interface PrincipalService {

	Principal createPrincipal(Principal principal);

	Principal getPrincipalById(String principalId);

    List<Principal> getAllPrincipals();

    Principal updatePrincipal(Principal principal);

    void deletePrincipal(Long principalId);

}
