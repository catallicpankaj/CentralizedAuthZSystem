package com.pankaj.cas.roles.service;

import com.pankaj.cas.roles.entity.Roles;

public interface RolesService {

	Roles createRoles(Roles roles);

	Roles getRoleById(Long buId);

    Roles updateRole(Roles roles);

    void deleteRole(Long buId);

}
