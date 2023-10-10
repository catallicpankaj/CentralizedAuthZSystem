package com.pankaj.cas.principal.resources.mapping.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "principalresources-mapping")
public class PrincipalResourcesMap {

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
