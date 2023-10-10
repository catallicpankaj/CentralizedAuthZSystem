package com.pankaj.cas.centralauthz.experience.service.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resources {
	
	private Long resourceId;
	
	private String resource;
	
	private Timestamp createdDate;
	
	private Timestamp lastModifiedDate;
}
