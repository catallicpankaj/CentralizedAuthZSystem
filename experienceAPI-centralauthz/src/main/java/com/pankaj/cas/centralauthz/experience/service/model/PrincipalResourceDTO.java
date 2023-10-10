package com.pankaj.cas.centralauthz.experience.service.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalResourceDTO {

	private String orgId;
	private String principalId;
	private List<String> roles;
	private List<ResourcesDTO> resources;
	
}
