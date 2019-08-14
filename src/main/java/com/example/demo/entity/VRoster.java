package com.example.demo.entity;

public class VRoster extends BaseModel {
		private static final long serialVersionUID = -6584442614334155661L;
		private String firstname;
		private String lastname;
		private String hrId;
		private String teamName;
	private String managerName;
		
		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		private Long teamId;

		private boolean errorProcessed;

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

		public Long getTeamId() {
			return teamId;
		}

		public void setTeamId(Long teamId) {
			this.teamId = teamId;
		}

		public boolean isErrorProcessed() {
			return errorProcessed;
		}

		public void setErrorProcessed(boolean errorProcessed) {
			this.errorProcessed = errorProcessed;
		}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

}
