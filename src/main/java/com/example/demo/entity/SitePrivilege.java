package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class SitePrivilege {

	@EmbeddedId
	private SitePrivilegeKey id;

//	@Id
//	private String hrId;
//	
//	private String dataScopeKey;

}
