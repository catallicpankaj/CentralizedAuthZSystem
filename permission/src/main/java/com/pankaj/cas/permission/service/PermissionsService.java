package com.pankaj.cas.permission.service;

import java.util.List;

import com.pankaj.cas.permission.entity.Permissions;

public interface PermissionsService {

	Permissions createPermissions(Permissions permissions);
	
	List<Permissions> getAllPermissions();

	Permissions getPermissionById(String permissionId);

    Permissions updatePermission(Permissions permission);

    void deletePermission(String permissionId);

}
