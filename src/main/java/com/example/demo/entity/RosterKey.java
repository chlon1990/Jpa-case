package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class RosterKey extends BaseModel {
	private static final long serialVersionUID = 5394646566384900000L;

	private String hrId;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Override
	public int hashCode() {
		if(this.hrId==null || this.startDate==null){
			return (int)System.currentTimeMillis();
		}
		
		return new HashCodeBuilder().append(this.hrId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this.hrId==null || this.startDate==null){
			return false;
		}
		
		if(obj==null || !(obj instanceof RosterKey)){
			return false;
		}else{
			RosterKey another = (RosterKey)obj;
			return new EqualsBuilder().append(this.hrId, another.hrId).append(this.startDate, another.startDate).isEquals();
		}
	}

}
