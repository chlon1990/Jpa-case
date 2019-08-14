package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Roster extends VRoster {

	private static final long serialVersionUID = 5381040507196629873L;

	@EmbeddedId
	private RosterKey id;
	
	private String dataScopeKey;

	private String firstname;
	private String lastname;

	private Long teamId;
	private String teamName;

	@JsonIgnoreProperties
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="leaders",fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Team> controlledTeams = new ArrayList<Team>();
	
	public String getHrId() {
		getPKInternal();
		return this.id.getHrId();
	}

	public void setHrId(String hrId) {
		getPKInternal();
		this.id.setHrId(hrId);
	}
	
	public Date getStartDate() {
        getPKInternal();
        return this.id.getStartDate();
    }
	public void setStartDate(Date startDate) {
	    getPKInternal();
	    this.id.setStartDate(startDate);
	}

	private void getPKInternal() {
		if (this.id == null) {
			this.id = new RosterKey();
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public List<Team> getControlledTeams() {
		return controlledTeams;
	}

	public void setControlledTeams(List<Team> controlledTeams) {
		this.controlledTeams = controlledTeams;
	}

	public RosterKey getId() {
		return id;
	}

	public void setId(RosterKey id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean isTeamLead(Team team) {
			return this.getHrId().equalsIgnoreCase(team.getTlId());
		}

	@JsonIgnore
	public boolean isTeamLead(String teamName, Team testTeam) {
		String assembledTeamName = StringUtils.trimToEmpty("TEAM " + this.getFirstname() + " " + this.getLastname());
		String assembledTeamNameB = StringUtils
				.trimToEmpty("TEAM " + this.getFirstname() + " " + this.getLastname().split(" ")[0]);

		if (teamName == null && testTeam != null) {
			teamName = testTeam.getName();
		}

		teamName = StringUtils.trimToEmpty(teamName);

		return (assembledTeamName).equalsIgnoreCase(teamName) || assembledTeamNameB.equalsIgnoreCase(teamName);
	}
	
	@Override
	public int hashCode() {
		if(this.id==null){
			return (int)System.currentTimeMillis();
		}
		return new HashCodeBuilder().append(this.id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this.id==null){
			return false;
		}
		
		if(obj==null || !(obj instanceof Roster)){
			return false;
		}else{
			Roster another = (Roster)obj;
			return new EqualsBuilder().append(this.id, another.id).isEquals();
		}
	}

	@Override
	public String toString() {
		return "Roster{" +
				"id=" + id +
				", dataScopeKey='" + dataScopeKey + '\'' +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", teamName='" + teamName + '\'' +
				", teamId=" + teamId +
				'}';
	}

    public String getDataScopeKey() {
        return dataScopeKey;
    }

    public void setDataScopeKey(String dataScopeKey) {
        this.dataScopeKey = dataScopeKey;
    }

}
