package com.pankaj.cas.centralauthz.experience.service.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalResourceMapping {
	
	@Id
	private String id;
	
	private String principalId;
	
	private String resourcesId;
	
	private String permissionId;
	
	@Column(nullable = false)
	private Timestamp createdDate;
	
	@Column(nullable = false)
	private Timestamp lastModifiedDate;
	

}
