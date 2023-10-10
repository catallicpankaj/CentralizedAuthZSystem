package com.pankaj.cas.permission.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {

	private boolean canCreate;
	private boolean canRead;
	private boolean canUpdate;
	private boolean canDelete;
	
}
