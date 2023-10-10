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
public class ResourcesDTO {
	
	private Long id;
	private String resource;
	private List<String> permissions;

}
