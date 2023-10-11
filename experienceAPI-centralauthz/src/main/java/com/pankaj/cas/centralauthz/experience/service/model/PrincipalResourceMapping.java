package com.pankaj.cas.centralauthz.experience.service.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalResourceMapping {
	
	private String id;
	
	private String principalId;
	
	private String resourcesId;
	
	private String permissionId;
	
	private Timestamp createdDate;
	
	private Timestamp lastModifiedDate;
	

}
