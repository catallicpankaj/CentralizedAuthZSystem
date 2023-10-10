package com.pankaj.cas.centralauthz.experience.service.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permissions {
	private String permissionId;
	
	private boolean canCreate;
	
	private boolean canRead;
	
	private boolean canUpdate;
	
	private boolean canDelete;
	
	private Timestamp createdDate;
	
	private Timestamp lastModifiedDate;
}
