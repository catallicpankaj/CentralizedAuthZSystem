package com.pankaj.cas.permission.service;

import com.pankaj.cas.permission.entity.Permissions;

public interface PermissionsService {

	Permissions createPermissions(Permissions permissions);

	Permissions getPermissionById(String permissionId);

    Permissions updatePermission(Permissions permission);

    void deletePermission(String permissionId);

}
