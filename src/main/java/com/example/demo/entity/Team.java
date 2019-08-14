package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Yao Pan
 *
 */
@Entity
public class Team implements Serializable {

	private static final long serialVersionUID = -74798990307392047L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String tlId;
	private String dataScopeKey;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roster_teamleaders", joinColumns = {
			@JoinColumn(name = "team_id", nullable = false) }, inverseJoinColumns = {
					 @JoinColumn(name = "hr_id", nullable = false),@JoinColumn(name = "start_date", nullable = false)})
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Roster> leaders = new ArrayList<Roster>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Roster> getLeaders() {
		return leaders;
	}
	public void setLeaders(List<Roster> leaders) {
		this.leaders = leaders;
	}
	public String getDataScopeKey() {
		return dataScopeKey;
	}
	public void setDataScopeKey(String dataScopeKey) {
		this.dataScopeKey = dataScopeKey;
	}
	public String getTlId() {
		return tlId;
	}
	public void setTlId(String tlId) {
		this.tlId = tlId;
	}
	
}

