package com.hk.trip.command;

public class UpdateUserRoleCommand {

	private String id;
	
	private String role;

	@Override
	public String toString() {
		return "UpdateUserRoleCommand [id=" + id + ", role=" + role + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UpdateUserRoleCommand(String id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public UpdateUserRoleCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
}
