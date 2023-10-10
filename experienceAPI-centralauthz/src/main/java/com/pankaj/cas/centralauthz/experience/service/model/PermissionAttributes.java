package com.pankaj.cas.centralauthz.experience.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissionAttributes {

	private boolean canCreate;
	private boolean canRead;
	private boolean canUpdate;
	private boolean canDelete;
}
