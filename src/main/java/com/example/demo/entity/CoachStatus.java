package com.example.demo.entity;

public enum CoachStatus {
	PLANNED(0), COMPLETED(1), CANCELLED(2), ONGOING(3), ACKNOWLEDGED(4), IN_COMPLETED(5), COMPLETED_ACKNOWLEDGED(6);

	private int status;

	private CoachStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return this.status;
	}

}
