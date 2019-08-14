package com.example.demo.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	private static final long serialVersionUID = -7589199058391184406L;

	@Transient
	private String oldHrId;

	@Transient
	private String newPassword;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hrId")
	private List<SitePrivilege> privileges;

	@Transient
	private String roleType;

	@Id
	@Column(unique = true)
	private String hrId;

	private String dataScopeKey;
	private String firstname;
	private String lastname;

	@JsonIgnore
	private String password;

	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Calendar lastChange;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	@OrderBy("id")
	private Set<Role> roles = new HashSet<Role>(0);

	public String getId() {
		return this.hrId;
	}

	public String getHrId() {
		return hrId;
	}

	public void setHrId(String hrId) {
		this.hrId = hrId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public String getDataScopeKey() {
		return dataScopeKey;
	}

	public void setDataScopeKey(String dataScopeKey) {
		this.dataScopeKey = dataScopeKey;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this.getHrId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		return EqualsBuilder.reflectionEquals(this.getHrId(), ((Account) obj).getHrId());
	}

	public boolean isL3() {
		boolean isL3 = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("L3".equals(role.getName())) {
					isL3 = true;
				}
			}
		}

		return isL3;
	}

	public boolean isL1() {
		boolean isL1 = false;
		boolean isL2 = false;
		boolean isL3 = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("L1".equals(role.getName())) {
					isL1 = true;
				} else if ("L2".equals(role.getName())) {
					isL2 = true;
				} else if ("L3".equals(role.getName())) {
					isL3 = true;
				}
			}
		}

		return isL1 && !isL2 && !isL3;
	}

	public boolean isL2() {
		boolean isL2 = false;
		boolean isL3 = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("L2".equals(role.getName())) {
					isL2 = true;
				} else if ("L3".equals(role.getName())) {
					isL3 = true;
				}
			}
		}

		return isL2 && !isL3;
	}

	public boolean isLC() {
		boolean isLC = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("LC".equals(role.getName())) {
					isLC = true;
				}
			}
		}

		return isLC;
	}

	public boolean isVP() {
		boolean isLC = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("VP".equals(role.getName())) {
					isLC = true;
				}
			}
		}

		return isLC;
	}

	public boolean isSVP() {
		boolean isLC = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("SVP".equals(role.getName())) {
					isLC = true;
				}
			}
		}

		return isLC;
	}

	public boolean isSVPAdmin() {
		boolean isSAdmin = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("VP/SVP ADMIN".equals(role.getName())) {
					isSAdmin = true;
				}
			}
		}

		return isSAdmin;
	}

	public boolean isHighPriv() {
		boolean priv = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("LC".equals(role.getName()) || "VP".equals(role.getName()) || "SVP".equals(role.getName())
						|| "L4".equalsIgnoreCase(role.getName())) {
					priv = true;
				}
			}
		}

		return isL3() || priv;
	}

	public boolean isCrossSite() {

		boolean crossSite = false;

		if (this.getRoles() != null) {
			for (Role role : roles) {
				if ("VP".equals(role.getName()) || "SVP".equals(role.getName())
						|| "L4".equalsIgnoreCase(role.getName())) {
					crossSite = true;
					break;
				}
			}
		}
		return crossSite;
	}

	public boolean isAgent() {

		return roles.size() == 1 && "AGENT".equals(roles.iterator().next().getName());
	}

	public Calendar getLastChange() {
		return lastChange;
	}

	public void setLastChange(Calendar lastChange) {
		this.lastChange = lastChange;
	}

	public String getOldHrId() {
		return oldHrId;
	}

	public void setOldHrId(String oldHrId) {
		this.oldHrId = oldHrId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<SitePrivilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<SitePrivilege> privileges) {
		this.privileges = privileges;
	}

}
