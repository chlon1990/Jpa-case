package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SitePrivilegeKey implements Serializable {
	private static final long serialVersionUID = 5394646566384900000L;

	private String hrId;

	private String dataScopeKey;

	
	public SitePrivilegeKey() {};
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataScopeKey == null) ? 0 : dataScopeKey.hashCode());
		result = prime * result + ((hrId == null) ? 0 : hrId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SitePrivilegeKey other = (SitePrivilegeKey) obj;
		if (dataScopeKey == null) {
			if (other.dataScopeKey != null)
				return false;
		} else if (!dataScopeKey.equals(other.dataScopeKey))
			return false;
		if (hrId == null) {
			if (other.hrId != null)
				return false;
		} else if (!hrId.equals(other.hrId))
			return false;
		return true;
	}

}
